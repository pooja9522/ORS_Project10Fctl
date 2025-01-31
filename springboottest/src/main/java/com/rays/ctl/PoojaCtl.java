package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.PoojaDTO;
import com.rays.form.PoojaForm;
import com.rays.service.PoojaServiceInt;

@RestController
@RequestMapping(value = "Pooja")
public class PoojaCtl extends BaseCtl<PoojaForm, PoojaDTO, PoojaServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> specializationMap = new HashMap<>();
        specializationMap.put(1, "Red");
        specializationMap.put(2, "Blue");
        specializationMap.put(3, "Green");
        specializationMap.put(4, "Black");

        List<Map<String, Object>> special = new ArrayList<>();
        specializationMap.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            special.add(item);
        });

        res.addResult("special", special);

        return res;
    }
    
    
    @PostMapping
	public ResponseEntity<String> createPooja(@Valid @RequestBody PoojaForm poojaForm) {
		// Handle the logic to save the patient
		return new ResponseEntity<>("pooja created successfully", HttpStatus.CREATED);
	}
}
