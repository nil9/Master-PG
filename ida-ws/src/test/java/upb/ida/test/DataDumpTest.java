package upb.ida.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import upb.ida.Application;
import upb.ida.util.DataDumpUtil;
@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = {Application.class})
public class DataDumpTest {
	@Autowired
	DataDumpUtil dataDumpUtil;
	
	
	@Test
	public void  getClusteringAlgoNamesPosTest() {
		List<String> algonames = dataDumpUtil.getClusteringAlgoNames();
		List<String> resList = new ArrayList<>();
		resList.add("KMeans");
		resList.add("AffinityPropagation");
		assertEquals(algonames, resList);
		assertEquals(algonames.size(),2);
		
		//System.out.println(dataDumpUtil.getClusteringAlgoNames());
	}
	
	@Test
	public void  getClusteringAlgoNamesNegTest() {
		List<String> algonames = dataDumpUtil.getClusteringAlgoNames();
		List<String> resList = new ArrayList<>();
		
		resList.add("AffinityPropagation");
		assertNotEquals(algonames, resList);
		assertEquals(algonames.size(),2);
		
		//System.out.println(dataDumpUtil.getClusteringAlgoNames());
	}

	@Test
	public void  getClusteringAlgoNamesExtTest() {
		List<String> algonames = dataDumpUtil.getClusteringAlgoNames();
		List<String> resList = new ArrayList<>();
		resList.add("Keans");
		resList.add("AffinityPropagation");
		resList.add("KMeans_TEST");
		assertNotEquals(algonames, resList);
		assertEquals(algonames.size(),2);
		
		//System.out.println(dataDumpUtil.getClusteringAlgoNames());
	}
}
