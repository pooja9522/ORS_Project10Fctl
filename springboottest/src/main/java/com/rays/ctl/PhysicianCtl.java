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
import com.rays.dto.PhysicianDTO;
import com.rays.form.PhysicianForm;
import com.rays.service.PhysicianServiceInt;

@RestController
@RequestMapping(value = "Physician")
public class PhysicianCtl extends BaseCtl<PhysicianForm, PhysicianDTO, PhysicianServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> phyListMap = new HashMap<>();
        phyListMap.put(1, "Neurologist");
        phyListMap.put(2, "Dentist");
        phyListMap.put(3, "Cardiologist");
        phyListMap.put(4, "genralist");

        List<Map<String, Object>> phyList= new ArrayList<>();
        phyListMap.forEach((key, value) -> {
            Map<String, Object> phy = new HashMap<>();
            phy.put("key", key);
            phy.put("value", value);
            phyList.add(phy);
        });

        res.addResult("phyList", phyList);

        return res;
    }
}
