package com.atmecs.apitest.testdataprovider;

import org.testng.annotations.DataProvider;
import com.atmecs.apitest.constants.FileConstants;
import com.atmecs.apitest.utils.JsonReader;
import com.atmecs.apitest.utils.PropertyReader;

		public class UserDataProvider {
				
				@DataProvider(name = "user")
				public static Object[][] getUsersData(){
					PropertyReader usersDataReader = new PropertyReader(FileConstants.USERS_DATA_PROP_FILE);
					String url = usersDataReader.get("url");
					String firstName = usersDataReader.get("firstName");
					String lastName = usersDataReader.get("lastName");
					
					Object[][] data = new Object[1][3];
					data[0][0] = url;
					data[0][1] = firstName;
					data[0][2] = lastName;
					
					return data;
					
				}
				@DataProvider (name = "user")
				public static Object[][] getCreateUserData() {
					JsonReader jsonReader = new JsonReader(FileConstants.USER_DATA_JSON_FILE);
					Object object = jsonReader.parse();
					Object[][] data = new Object[1][1];
					data[0][0] = object;
					return data;
				}
}
