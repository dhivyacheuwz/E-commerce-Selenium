package utils;

import java.util.List;
import java.io.File;
import model.PaymentData;
import model.Paymentwrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {
	
	 public static List<PaymentData> getPaymentData(String Filepath) {
	        try {
	            ObjectMapper mapper = new ObjectMapper();

	            Paymentwrapper wrapper = mapper.readValue(
	                new File(Filepath),
	                Paymentwrapper.class
	            );

	            return wrapper.getPayments();

	        } catch (Exception e) {
	            throw new RuntimeException("Failed to read JSON", e);
	        }
	    }
	}