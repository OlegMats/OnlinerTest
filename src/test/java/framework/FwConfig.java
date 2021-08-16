package framework;

public class FwConfig {
    public DriverSettings driver;
    public TestSettings test;

    public DriverSettings getDriver() {
        return driver;
    }

    public void setDriver(DriverSettings driver) {
        this.driver = driver;
    }

    public TestSettings getTest() {
        return test;
    }

    public void setTest(TestSettings test) {
        this.test = test;
    }


    public class DriverSettings {
        public String browser;

        public String getBrowser() {
            return browser;
        }

        public void setBrowser(String browser) {
            this.browser = browser;
        }
    }

    public class TestSettings {
        public String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
