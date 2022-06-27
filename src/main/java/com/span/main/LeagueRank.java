package com.span.main;

import com.span.league.*;
import java.io.IOException;

/**
 * Processes and ranks an input file containing team league results as per the <b>Problem Statement and Instructions</b> document.<br>
 * The program produces a ranked list of team league results stored in the output file specified on the command line.<br>
 * If the incorrect number of arguments is supplied a usage message is displayed.<br><br>
 *         The following status codes are returned for further processing by the operating system:<br><br>
 *          <ul>
 *              <li>SUCCESS = 0</li>
 *              <li>STATUS_INPUTFILE_NOTFOUND = -1</li>
 *              <li>STATUS_OUTPUTFILE_CANTCREATE = -2</li>
 *              <li>STATUS_INCORRECT_PARAMS = -3</li>
 *          </ul>
 *     <br>
 *     Program parameters and return value:<br><br>
 *     <ul>
 *         <li>param inputFileName  - The name of the file containing league results</li>
 *         <li>param outputFileName - The name of the file to which stats will be written</li>
 *         <li>returns - status code as specified above</li>
 *     </ul>
 *
 * @author Don Lewis-Enright
 *
*/
public class LeagueRank {

    public final static int STATUS_OK = 0;
    public final static int STATUS_INPUTFILE_NOTFOUND = -1;
    public final static int STATUS_OUTPUTFILE_CANTCREATE = -2;
    public final static int STATUS_IOEXCEPTION = -3;
    public final static int STATUS_INCORRECT_PARAMS = -4;
    public final static int STATUS_NO_PARAMS = -5;
    public final static int STATUS_EXCEPTION = -6;

    public final static int MODE_STDIN = 1;
    public final static int MODE_FILES = 2;

    private static void Usage() {
        System.out.println("\nUsage:\n");
        System.out.println("1. Supply the league input data via a piped stream, and the output will be sent to stdout.");
        System.out.println("2. Alternatively specify league data input and output file names as parameters, and the output will be sent to the specified file.");
    }

    public static void main(String[] args) {
        int mode = 0;
        if(args.length == 0) {
            //STDIN
            try{
                if(System.in.available() == 0) {
                    Usage();
                    System.exit(STATUS_NO_PARAMS); //Return an exit status code for OS
                }
            } catch(IOException ex) {
                ex.printStackTrace();
                System.exit(STATUS_EXCEPTION);
            }
            mode = MODE_STDIN;
        } else
        if(args.length == 2) {
            //break out of static context by creating a new instance of our class and calling non-static method ProcessLeagueStats
            int statusCode = new LeagueRank().processLeagueStats(MODE_FILES, args);
            System.exit(statusCode);

        } else {
            Usage();
            System.exit(STATUS_INCORRECT_PARAMS); //Return an exit status code for OS
        }
    }

    public int processLeagueStats(int mode, String args[]){
        LeagueInputStream stream = mode == MODE_FILES ? new LeagueFileInputStreamImpl(args[0], args[1]) : new LeagueStdInInputStreamImpl();
        LeagueRankingTable rankingTable = new LeagueRankingTable(stream);
        int statusCode = rankingTable.processStream();

        return statusCode;
    }


}
