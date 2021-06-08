package com.cars.halamotor.presnter;

import com.cars.halamotor.model.ItemCCEMT;

import org.json.JSONObject;

public interface Login {
    void whenLoginSuccess(JSONObject obj,String platform,String platformID);
}
