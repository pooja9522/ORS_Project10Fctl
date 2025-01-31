package com.rays.ctl;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.ClientDTO;
import com.rays.form.ClientForm;
import com.rays.service.ClientServiceInt;

@RestController
@RequestMapping(value = "Client")
public class ClientCtl extends BaseCtl<ClientForm, ClientDTO, ClientServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> clientillnessMap = new HashMap<>();
        clientillnessMap.put(1, "BadQuality");
        clientillnessMap.put(2, "veryHorrable");
        clientillnessMap.put(3, "badBehaviour");
        clientillnessMap.put(4, "notinform");

        List<Map<String, Object>> clientillnessList = new ArrayList<>();
        clientillnessMap.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
           clientillnessList.add(item);
        });

        res.addResult("clientillnessList", clientillnessList);

        return res;
    }
}
