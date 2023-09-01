package TestCases;

import Api.RegisterApi;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DummyApiRegister {

	public static void main(String[] args) {
		RegisterApi registerApi =new RegisterApi();
		registerApi.Register();
		registerApi.GetCookies();
		System.out.println(registerApi.GetToken());
		System.out.println(registerApi.GetfirstName());
		System.out.println(registerApi.GetCookies());
	}

}
