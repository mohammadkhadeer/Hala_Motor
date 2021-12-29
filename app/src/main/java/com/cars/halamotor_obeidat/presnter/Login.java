package com.cars.halamotor_obeidat.presnter;

import org.json.JSONObject;

public interface Login {
    void whenLoginSuccess(JSONObject obj,String platform,String platformID,String photo);
}
