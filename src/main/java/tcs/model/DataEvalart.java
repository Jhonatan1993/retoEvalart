package tcs.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Data
public class DataEvalart {
    private String username;
    private String password;
    private String coordenada;
    private String suma;

    public static List<DataEvalart> setDataEvalarts(DataTable dataTable){
        List<DataEvalart> datos = new ArrayList<>();
        List<Map<String, String>> mapInfo =  dataTable.asMaps();
        for (Map<String, String> map:mapInfo){
            datos.add(new ObjectMapper().convertValue(map, DataEvalart.class));
        }
        return datos;
    }


}
