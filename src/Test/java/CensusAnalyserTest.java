package Test.java;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.CensusAnalyser;
import main.CensusAnalyserException;

public class CensusAnalyserTest {

	private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\ABHISHEK RAWANE\\eclipse-workspace\\IndianStatesCensus\\src\\Test\\resources\\IndianStatesCensus.csv";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndianStatesCensusData.csv";
	private static final String INCORRECT_FILE_FORMAT = "C:\\Users\\ABHISHEK RAWANE\\eclipse-workspace\\IndianStatesCensus\\src\\Test\\resources\\CensusDataInWrongFormat.txt";
	private static final String CSV_WITH_WRONG_DELIMITER = "C:\\Users\\ABHISHEK RAWANE\\eclipse-workspace\\IndianStatesCensus\\src\\Test\\resources\\CensusDataWithWrongDelimiter.csv";
	private static final String CSV_WITH_INCORRECT_HEADER = "C:\\Users\\ABHISHEK RAWANE\\eclipse-workspace\\IndianStatesCensus\\src\\Test\\resources\\CensusDataIncorrectHeader.csv";
	
	
	@Test
	public void givenIndianCensusCSVFile_WhenCorrectPath_ShouldReturnCorrectRecords() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(33, numOfRecords);
		} 
		catch (CensusAnalyserException e) {
		}
	}

	@Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} 
		catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
			e.printStackTrace();
		}
	}

	@Test
    public void givenIndianCensusCSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException() {
		
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INCORRECT_FILE_FORMAT);
		} 
		catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
			e.printStackTrace();
		}
    }
	
	@Test
    public void givenIndianCensusCSVFile_WhenCustomDelimiter_ShouldThrowException() {
		
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(CSV_WITH_WRONG_DELIMITER);
		} 
		catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, e.type);
			e.printStackTrace();
		}
    }
	
	@Test
    public void givenIndianCensusCSVFile_WhenIncorrectHeader_ShouldThrowException() {
		
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(CSV_WITH_INCORRECT_HEADER);
		} 
		catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, e.type);
			e.printStackTrace();
		}
    }
}