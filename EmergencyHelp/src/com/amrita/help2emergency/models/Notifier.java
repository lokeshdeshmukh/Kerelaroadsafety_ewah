package com.amrita.help2emergency.models;

import org.json.JSONObject;

public interface Notifier {
	public void onHospitalResults(JSONObject hospitals);
}
