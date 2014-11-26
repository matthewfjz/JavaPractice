package designPattern.listerner.weather;

public class Board implements IWeatherListener, IClockListener{

	@Override
	public void updateWeather(int areaCode, long temperature) {
		System.out.println("Board Update:"+"[Area Code:"+areaCode+", Temperature:"+temperature+"]");
	}

	@Override
	public void updateSharpHour(int hour) {
		System.out.println("Playing audio on board: Now it's "+ hour + " o'clock");
		
	}

}
