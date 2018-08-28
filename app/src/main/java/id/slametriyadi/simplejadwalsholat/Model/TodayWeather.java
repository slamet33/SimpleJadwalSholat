package id.slametriyadi.simplejadwalsholat.Model;

import com.google.gson.annotations.SerializedName;

public class TodayWeather{

	@SerializedName("temperature")
	private String temperature;

	@SerializedName("pressure")
	private int pressure;

	public void setTemperature(String temperature){
		this.temperature = temperature;
	}

	public String getTemperature(){
		return temperature;
	}

	public void setPressure(int pressure){
		this.pressure = pressure;
	}

	public int getPressure(){
		return pressure;
	}

	@Override
 	public String toString(){
		return 
			"TodayWeather{" + 
			"temperature = '" + temperature + '\'' + 
			",pressure = '" + pressure + '\'' + 
			"}";
		}
}