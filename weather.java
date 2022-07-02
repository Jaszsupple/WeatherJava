import java.util.Scanner;

class weather_forecast {

	double temprature;
	String skyCondition;

	// Default constructor
	public weather_forecast() {
		temprature = 70.00;
		skyCondition = "Sunny";
	}

	// Constructor with parameters
	public weather_forecast(int temprature, String skyCondition) {
		this.temprature = temprature;
		this.skyCondition = skyCondition;
	}

	// Getters and Setters
	public double getTemprature() {
		return temprature;
	}

	public void setTemprature(double temprature) {
		this.temprature = temprature;
	}

	public String getSkyCondition() {
		return skyCondition;
	}

	public void setSkyCondition(String skyCondition) {
		this.skyCondition = skyCondition;
	}

	// Fahrenheit to Celsius meathod
	public void toCelsius() {
		double tempInCelcius = (this.temprature - 32) * 5 / 9;
		System.out.println("Current temperature: " + String.format("%.2f", tempInCelcius) + " in celsius");
	}

	// ToString meathod
	public String toString() {
		return "Current temperature: " + temprature + " in Fahrenheit" + "\nCurrent sky condition: " + skyCondition
				+ "!";
	}

	// Consistent weather meathod
	public void isConsistent() {
		if (((temprature > 32) && (skyCondition == "Snowy")) || ((temprature < 32) && (skyCondition == "Rainy"))) {
			System.out.println("Be careful. The weather is not consistent!");
		}
	}
}

public class WeatherMain {

	public static void main(String[] args) {
		Scanner userinput = new Scanner(System.in);
		weather_forecast forecast = new weather_forecast();

		for (int flag = 0; flag == 0;) {
			System.out.print(
					"\n\t-----THE MENU----- \n1- Show the last update in Fahrenheit.\n2- Show the last update in Celsius."
							+ "\n3- Update.\n4- Exit.\nEnter your choice: ");
			int selectMenu = userinput.nextInt();

			switch (selectMenu) {
			case 1:
				System.out.println(forecast);
				break;

			case 2:
				forecast.toCelsius();
				System.out.println("Current sky condition: " + forecast.getSkyCondition() + "!");
				break;

			case 3: {
				while (flag == 0) {
					System.out.print("Enter the updated temperature in Fahrenheit: ");
					double inputTemprature = userinput.nextDouble();
					if ((inputTemprature >= -50) && (inputTemprature <= 150)) {
						forecast.setTemprature(inputTemprature);
						flag = 1;
					} else
						System.out.println("Please enter temptature between –50 and +150 degree fahrenheit!");
				}
				System.out.println("Temprature sucessfully updated");
				flag = 0;

				while (flag == 0) {
					System.out.print("Enter the updated sky condition: 1- Sunny, 2- Snowy, 3- Cloudy, 4- Rainy\n");
					int selectSky = userinput.nextInt();
					switch (selectSky) {
					case 1:
						forecast.setSkyCondition("Sunny");
						flag = 1;
						break;
					case 2:
						forecast.setSkyCondition("Snowy");
						flag = 1;
						break;
					case 3:
						forecast.setSkyCondition("Cloudy");
						flag = 1;
						break;
					case 4:
						forecast.setSkyCondition("Rainy");
						flag = 1;
						break;
					default:
						System.out.println("Invalid choice, try again!");
					}
				}
				System.out.println("Sky Condition sucessfully updated");
				flag = 0;
				forecast.isConsistent();
			}

				break;

			case 4:
				flag = 1;
				break;
			default:
				System.out.println("INVALID SELECTION, TRY AGAIN!");
			}
		}

		userinput.close();
		System.out.println("Thanks for using the application!");
	}
}
