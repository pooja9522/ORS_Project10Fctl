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
import com.rays.dto.PurchaseDTO;
import com.rays.form.PurchaseForm;
import com.rays.service.PurchaseServiceInt;

@RestController
@RequestMapping(value = "Purchase")
public class PurchaseCtl extends BaseCtl<PurchaseForm, PurchaseDTO, PurchaseServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> poojaMap = new HashMap<>();
        poojaMap.put(1, "laptop");
        poojaMap.put(2, "phone");
        poojaMap.put(3, "car");
        poojaMap.put(4, "ac");

        List<Map<String, Object>> pooja = new ArrayList<>();
        poojaMap.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            pooja.add(item);
        });

        res.addResult("pooja", pooja);

        return res;
    }
    
    
    @PostMapping
	public ResponseEntity<String> createPurchase(@Valid @RequestBody PurchaseForm PurchaseForm) {
		// Handle the logic to save the patient
		return new ResponseEntity<>("purchase created successfully", HttpStatus.CREATED);
	}
}
