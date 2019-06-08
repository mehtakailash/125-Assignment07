package util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogReader implements Closeable
{
    private static final Logger               root;
    static
    {
        root = Logger.getLogger( "" );
        root.setLevel( Level.FINEST );
    }
    
    private static final String RECORD_TAG      = "<record>";
    private static final String END_RECORD_TAG  = "</record>";
    private static final String MSG_TAG         = "<message>";
    private static final int    MSG_TAG_LEN     = MSG_TAG.length();
    private static final int    END_MSG_TAG_LEN = MSG_TAG_LEN + 1;
    
    private static final List<FileHandler>    allHandlers = new ArrayList<>();
    
    private FileHandler     fileHandler;
    private BufferedReader  reader;
    
    private synchronized static void addFileHandler( FileHandler handler )
    {
        allHandlers.add( handler );
        root.addHandler( handler );
    }
    
    private synchronized static void removeFileHandler( FileHandler handler )
    {
        allHandlers.remove( handler );
        root.removeHandler( handler );
    }
    
    public LogReader()
    {
        this( "temp.log", false );
    }
    
    public LogReader( boolean keep )
    {
        this( "temp.xml", keep );
    }
    
    public LogReader( String name, boolean keep )
    {
        try
        {
            File    file    = new File( name );
            if ( !keep )
                file.deleteOnExit();
            fileHandler = new FileHandler( file.getAbsolutePath(), false );
            addFileHandler( fileHandler );
            
            FileReader  fReader = new FileReader( file );
            reader = new BufferedReader( fReader );
        }
        catch ( IOException exc )
        {
            exc.printStackTrace();
            System.exit( 1 );
        }
    }
    
    public String nextMessage()
    {
        String  line    = null;
        try
        {
            // find the start of the next record
            while ( (line = reader.readLine()) != null 
                    && !line.contains( RECORD_TAG )
                  )
                ;
            
            // find the start of the message within the record
            while ( (line = reader.readLine()) != null
                    && !line.contains( MSG_TAG)
                  )
                if ( line.contains( END_RECORD_TAG ) )
                    throw new Exception( "Couldn't find record with message" );
        }
        catch ( Exception exc )
        {
            exc.printStackTrace();
            System.exit( 1 );
        }
        
        if ( line != null )
        {
            // remove the cruft: "  <message>this is the non-crufty bit</message>
            line = line.trim();
            int len = line.length();
            line = line.substring( MSG_TAG_LEN, len - END_MSG_TAG_LEN );
        }
        return line;
    }
    
    @Override
    public synchronized void close()
    {
        try
        {
            if ( reader != null )
                reader.close();
            if ( fileHandler != null )
            {
                removeFileHandler( fileHandler );
                fileHandler.close();
            }
            reader = null;
            fileHandler = null;
        }
        catch ( IOException exc )
        {
            exc.printStackTrace();
            System.exit( 1 );
        }
    }

}
