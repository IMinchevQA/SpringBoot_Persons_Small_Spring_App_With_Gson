package app.io;

import app.domain.dto.PersonDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class JSONParser {

    private Gson gson;

    @Autowired
    private FileIOUtil fileIOUtil;

    public JSONParser() {
        /** With use of .setPrettyPrinting() a Person will be serialized and written on a MULTIPLE rows in file personsOutput.json*/
        this.gson = new GsonBuilder().setPrettyPrinting().create();

        /** Without use of .setPrettyPrinting() Person will be serialized and written on a SINGLE row in file personsOutput.json*/
            //this.gson = new GsonBuilder().create();

    }

    public <T> T importJson(Class<T> tClass, String pathToFile) throws IOException {
        /**
         * Some old code on the following 2 rows.
         * //InputStream str = new FileInputStream(pathToFile);
         * //BufferedReader reader = new BufferedReader(new InputStreamReader(str));
         * T mappedObj = gson.fromJson(reader, tClass);*/

        String content = this.fileIOUtil.read(pathToFile);
        T mappedObj = this.gson.fromJson(content, tClass);
        return mappedObj;
    }

    public void outputJson(PersonDto dto, String pathToFile) throws IOException {
        String content = this.gson.toJson(dto);
        this.fileIOUtil.write(content, pathToFile);
    }
}
