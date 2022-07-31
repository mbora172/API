package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class utils {
    public static RequestSpecification request;//static keep firsy run data
    public RequestSpecification requestSpecification() throws IOException {
        if(request==null){
        File loging=new File("logging.txt"); //my solutioun creating log file
        FileOutputStream out=new FileOutputStream(loging);//making output
        PrintStream log=new PrintStream(new FilterOutputStream(out));
        request = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
        return request;}return request;
    }
    public static String getGlobalValue(String key) throws IOException {//properties reader and path provide for our properties
        Properties properties=new Properties();//scanner for prop
        FileInputStream fileInputStream=new FileInputStream("src/test/java/resources/global.properties");//file path inp
        properties.load(fileInputStream);//u load file path input to prop
        return properties.getProperty(key);  //what u want from prop-key(url) and return sting
    }
    public String getJsonPath(Response response, String key)
    {
        String resp=response.asString();
        JsonPath jsonPath=new JsonPath(resp);
       return jsonPath.get(key).toString();

    }
    }
