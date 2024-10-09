package com.grafanaScereenshot.dashboardScreenshot;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.grafanaScereenshot.dashboardScreenshot.*;

public class screenshotMain {
	// 23 computeResources
	// 22 serviceMetric 14-c3po 5-hikari
	static String[] pods = new String[] { "ac-" };

	static String[] idsPods = new String[] { "iicsgateway" };
	static String[] commonPods = new String[] { "package-manager" };
	static String[] globalPods = new String[] { "v3api" };

	static String[] podsServiceMetrics = new String[] { "admin", "bundle", "ca-", "callback", "cis", "cloudshell",
			"cloudui", "frs", "kms", "license", "migration", "preference", "session", "vcs", "v3api" };
	//
	static String[] podsServiceMetricsGlobal = new String[] { "v3api", "scim", "branding", "content-repository", "ma",
			"authz", "identity-service" };
	static ArrayList<String> c3po = new ArrayList<String>(
			Arrays.asList("admin", "callback", "cloudshell", "frs", "kms", "migration", "preference", "vcs", "scim"));
	static ArrayList<String> hikari = new ArrayList<String>(Arrays.asList("bundle", "cis", "license", "session",
			"authz", "branding", "content-repository", "identity-service", "ma"));

	static String screenshotlocation = "";

	public static void main(String[] args) throws Exception {

		// getting properties from files based on environment
		String env = args[0], startTime = args[1], endTime = args[2], username = args[3], password = args[4],
				addHours = args[5];
		screenshotlocation = System.getProperty("user.dir") + "\\screenshot";

		String propFileName = env + ".properties"; // Replace with your actual properties file name
		ClassLoader loader = screenshotMain.class.getClassLoader();
		InputStream inputStream = loader.getResourceAsStream(propFileName);
		if (inputStream == null) {
			throw new RuntimeException("Cannot find properties file: " + propFileName);
		}

		Properties p = new Properties();
		p.load(inputStream);
		String datasource = p.getProperty("datasource"), cluster = p.getProperty("cluster"),
				pkmcluster = p.getProperty("pkmcluster"), IDScluster = p.getProperty("IDScluster"),
				namespace = p.getProperty("namespace"), IDSnamespace = p.getProperty("IDSnamespace"),
				commonNamespace = p.getProperty("commonNamespace"),
				var_deployment_ctx_var = p.getProperty("var-deployment_ctx_var"),
				ids_var_deployment_ctx_var = p.getProperty("ids-var-deployment_ctx_var");

		elements.grafanaUrl = createGrafanaUrl("computeResources", datasource, IDScluster, IDSnamespace, pods[0],
				startTime, endTime, addHours);
		screenshotMain obj = new screenshotMain();
		obj.setChromeDriver();
		WebDriver chromedriver = new ChromeDriver();
		chromedriver.manage().window().maximize();
		chromedriver.get(elements.grafanaUrl);
		chromedriver.findElement(By.xpath(elements.signUpWithOKTA_Button)).click();
		commonMethods.getElementByXpath(chromedriver, 1000, elements.oktaUsername);
		chromedriver.findElement(By.xpath(elements.oktaUsername)).sendKeys(username);
		chromedriver.findElement(By.xpath(elements.oktaPassword)).sendKeys(password);
		chromedriver.findElement(By.xpath(elements.oktaSignIn)).click();
		for (int i = 0; i < idsPods.length; i++) {

			selectPod("computeResources", chromedriver, idsPods[i]);
			computeResourcesPodDashboard(chromedriver, i, idsPods[i], "IDS");
		}

		selectCluster(chromedriver, pkmcluster);
		selectNamespace(chromedriver, commonNamespace);
		for (int i = 0; i < commonPods.length; i++) {

			selectPod("computeResources", chromedriver, commonPods[i]);
			computeResourcesPodDashboard(chromedriver, i, commonPods[i], "Common");
		}

		selectCluster(chromedriver, cluster);
		selectNamespace(chromedriver, namespace);
		for (int i = 0; i < pods.length; i++) {

			selectPod("computeResources", chromedriver, pods[i]);
			computeResourcesPodDashboard(chromedriver, i, pods[i], "USW1");
		}
		/*
		 * // Open a new tab/window ((JavascriptExecutor)
		 * chromedriver).executeScript("window.open();");
		 * 
		 * // Switch to the new tab/window ArrayList<String> tabs = new
		 * ArrayList<String>(chromedriver.getWindowHandles());
		 * chromedriver.switchTo().window(tabs.get(1)); elements.grafanaUrl =
		 * createGrafanaUrl("ServiceMetrics", datasource, IDScluster,
		 * ids_var_deployment_ctx_var, pods[0], startTime, endTime, addHours);
		 * 
		 * // Open a URL in the new tab/window chromedriver.get(elements.grafanaUrl);
		 * for (int i = 0; i < podsServiceMetricsGlobal.length; i++) {
		 * 
		 * // Launch Website selectPodServiceMetrics(chromedriver,
		 * podsServiceMetricsGlobal[i]); serviceMetricsDashboard(chromedriver, i,
		 * podsServiceMetricsGlobal[i], "Global"); }
		 */
		System.out.println("TEST HAS ENDED !!! Collect your screenshot from the folder");
		chromedriver.close();
		chromedriver.quit();

	}

	private void setChromeDriver() throws IOException {

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("chromedriver.exe");

		// Write the binary to a temporary file
		File driverFile = File.createTempFile("chromedriver", ".exe");
		OutputStream outputStream = new FileOutputStream(driverFile);
		IOUtils.copy(inputStream, outputStream);
		outputStream.close();
		inputStream.close();

		// Set the path to the ChromeDriver binary
		System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
	}

	private static void selectPodServiceMetrics(WebDriver chromedriver, String pod) {

		new WebDriverWait(chromedriver, 60)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.podInputServiceMetrics)));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commonMethods.getElementByXpath(chromedriver, 1000, elements.podInputServiceMetrics).click();
		commonMethods.getElementByXpath(chromedriver, 1000, elements.podInputPointServiceMetrics).sendKeys(pod);
		commonMethods.getElementByXpath(chromedriver, 1000, elements.podElement1ServiceMetrics).click();

	}

	private static void selectNamespaceServiceMetrics(WebDriver chromedriver, String namespace) {
		new WebDriverWait(chromedriver, 60)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.DeploymentInputServiceMetrics)));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commonMethods.getElementByXpath(chromedriver, 1000, elements.DeploymentInputServiceMetrics).click();
		commonMethods.getElementByXpath(chromedriver, 1000, elements.DeploymentInputServiceMetricsInputPoint)
				.sendKeys(namespace);
		commonMethods.getElementByXpath(chromedriver, 1000, elements.DeploymentInputServiceMetricsElement1).click();

	}

	private static void selectCluster(WebDriver chromedriver, String cluster) throws InterruptedException {
		new WebDriverWait(chromedriver, 60)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.clusterInput)));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commonMethods.getElementByXpath(chromedriver, 1000, elements.clusterInput).click();
		commonMethods.getElementByXpath(chromedriver, 1000, elements.clusterInputPoint).sendKeys(cluster);
		commonMethods.getElementByXpath(chromedriver, 1000, elements.clusterpodElement1).click();

	}

	private static void selectNamespace(WebDriver chromedriver, String namespace) throws InterruptedException {
		new WebDriverWait(chromedriver, 60)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.namespaceInput)));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commonMethods.getElementByXpath(chromedriver, 1000, elements.namespaceInput).click();
		commonMethods.getElementByXpath(chromedriver, 1000, elements.namespaceInputPoint).sendKeys(namespace);
		commonMethods.getElementByXpath(chromedriver, 1000, elements.namespacepodElement1).click();

	}

	private static void selectPod(String dashboard, WebDriver chromedriver, String pod) throws InterruptedException {
		new WebDriverWait(chromedriver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath(elements.podInput)));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commonMethods.getElementByXpath(chromedriver, 1000, elements.podInput).click();
		commonMethods.getElementByXpath(chromedriver, 1000, elements.podInputPoint).sendKeys(pod);

		// finding and picking the service Pod
		if (commonMethods.isKeywordPresentInString(chromedriver, elements.podElement1, elements.wrongPodSubString)) {
			if (commonMethods.isKeywordPresentInString(chromedriver, elements.podElement2,
					elements.wrongPodSubString)) {
				if (commonMethods.isKeywordPresentInString(chromedriver, elements.podElement3,
						elements.wrongPodSubString)) {
					if (commonMethods.isKeywordPresentInString(chromedriver, elements.podElement4,
							elements.wrongPodSubString)) {
						if (commonMethods.isKeywordPresentInString(chromedriver, elements.podElement5,
								elements.wrongPodSubString)) {
							commonMethods.getElementByXpath(chromedriver, 1000, elements.podElement6).click();
						} else {
							commonMethods.getElementByXpath(chromedriver, 1000, elements.podElement5).click();
						}
					} else {
						commonMethods.getElementByXpath(chromedriver, 1000, elements.podElement4).click();
					}
				} else {
					commonMethods.getElementByXpath(chromedriver, 1000, elements.podElement3).click();
				}
			} else {
				commonMethods.getElementByXpath(chromedriver, 1000, elements.podElement2).click();
			}
		} else {
			// System.out.println("clicking pod1 element");
			commonMethods.getElementByXpath(chromedriver, 1000, elements.podElement1).click();
		}

	}

	private static String createGrafanaUrl(String dashboardName, String datasource, String cluster, String namespace,
			String pod, String fromTime, String toTime, String addHours) throws ParseException {
		String grafanaURL = "";
		String fromDate = Long.toString(commonMethods.addHoursAndReturnEpoch(fromTime, addHours));
		String toDate = Long.toString(commonMethods.addHoursAndReturnEpoch(toTime, addHours));
		// String fromDate = Long.toString(commonMethods.returnEpoch(fromTime));
		// String toDate = Long.toString(commonMethods.returnEpoch(toTime));
		if (dashboardName.equals("computeResources")) {
			grafanaURL = "https://grafananp.cloudtrust.rocks/d/6581e46e4e5c7ba40a07646395ef7b2/kubernetes-compute-resources-pod?";
			grafanaURL += "orgId=1&var-datasource=" + datasource + "&var-cluster=" + cluster + "&var-namespace="
					+ namespace + "&var-interval=4h&var-container=All&";

			grafanaURL += "from=" + fromDate + "&to=" + toDate;
		} else if (dashboardName.equals("ServiceMetrics")) {
			grafanaURL = "https://grafananp.cloudtrust.rocks/d/MUO-AwZMz1/iics-platform-service-metrics-perf?orgId=1&from=";
			grafanaURL += fromDate + "&to=" + toDate;
			grafanaURL += "&var-datasource_var=" + datasource + "&var-deployment_ctx_var=" + namespace;
			grafanaURL += "&var-instance_var=All&var-method_var=All&var-outbound_service_var=All&var-outbound_method_var=All&var-time_offset_var=12h";
		}
		System.out.println(grafanaURL);
		return grafanaURL;
	}

	public static void computeResourcesPodDashboard(WebDriver chromedriver, int Iteration, String pod, String namespace)
			throws Exception {
		commonMethods.getElementByXpath(chromedriver, 1000, elements.CPUusage);
		// scrolling down to view memory and network charts
		// commonMethods.scroll(chromedriver, 250);
		// commonMethods.getElementByXpath(chromedriver, 2000,
		// elements.KCRPMemoryQuota);
		if (Iteration == 0 && namespace.equalsIgnoreCase("IDS")) {
			commonMethods.scroll(chromedriver, 250);
			commonMethods.getElementByXpath(chromedriver, 2000, elements.KCRPMemoryQuota);

			new WebDriverWait(chromedriver, 10)
					.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.networkDropdown)));
			commonMethods.getElementByXpath(chromedriver, 1000, elements.networkDropdown).click();
		} else {
			commonMethods.scroll(chromedriver, 220);
			commonMethods.getElementByXpath(chromedriver, 2000, elements.KCRPMemoryQuota);
		}
		commonMethods.getElementByXpath(chromedriver, 1000, elements.transmitBandwidth);
		// zoom out and take screenshot
		commonMethods.zoom(chromedriver, 0.5);

		// wait until all dashboards are loaded
		String val = "", val1 = "", CPUval = "", CPUval3 = "", CPUval2 = "", MemoryVal = "", MemoryVal2 = "",
				MemoryVal3 = "";
		boolean isloaded = false, isNetworkGraphLoaded = false;
		Thread.sleep(5000);
		if ((commonMethods.isElementPresent(chromedriver, elements.CPUQuotaConatinerName))
				&& (commonMethods.isElementPresent(chromedriver, elements.memoryQuotaConatinerName))) {
			// waiting until network graph is loaded

			do {
				if ((commonMethods.isElementPresent(chromedriver, elements.trasmitBandwidthText))
						&& (commonMethods.isElementPresent(chromedriver, elements.receiveBandwidthText))) {
					WebElement ele1 = (commonMethods.getElementByXpath(chromedriver, 2000,
							elements.trasmitBandwidthText));
					val = ele1.getAttribute("innerText");
					WebElement ele2 = (commonMethods.getElementByXpath(chromedriver, 2000,
							elements.receiveBandwidthText));
					val1 = ele2.getAttribute("innerText");
					isNetworkGraphLoaded = val.contains(pod) && val1.contains(pod);
					System.out.println("-podname-" + pod + "---isNetworkGraphLoaded--" + isNetworkGraphLoaded
							+ "--trasmitBandwidthText-- " + val + " receiveBandwidthText !!!!!!" + val1);
				}
			} while (!isNetworkGraphLoaded);

			// waiting until cpu and memory quota graph loaded
			if (!pod.equalsIgnoreCase("iicsgateway")) {
				do {
					if (pod.endsWith("-")) {
						pod = pod.replace("-", "");
					}
					System.out.println(pod);
					Thread.sleep(1000);
					WebElement cval1 = (commonMethods.getElementByXpath(chromedriver, 1000,
							elements.CPUQuotaConatinerName));
					CPUval = cval1.getAttribute("innerText");
					WebElement cval2 = (commonMethods.getElementByXpath(chromedriver, 1000,
							elements.CPUQuotaConatinerName2));
					CPUval2 = cval2.getAttribute("innerText");
					WebElement cval3 = (commonMethods.getElementByXpath(chromedriver, 1000,
							elements.CPUQuotaConatinerName3));
					CPUval3 = cval3.getAttribute("innerText");
					// Thread.sleep(1000);
					WebElement Val1 = (commonMethods.getElementByXpath(chromedriver, 3000,
							elements.memoryQuotaConatinerName));
					MemoryVal = Val1.getAttribute("innerText");
					WebElement Val2 = (commonMethods.getElementByXpath(chromedriver, 3000,
							elements.memoryQuotaConatinerName2));
					MemoryVal2 = Val2.getAttribute("innerText");
					WebElement Val3 = (commonMethods.getElementByXpath(chromedriver, 3000,
							elements.memoryQuotaConatinerName3));
					MemoryVal3 = Val3.getAttribute("innerText");

					isloaded = (CPUval.contains(pod) || CPUval2.contains(pod) || CPUval3.contains(pod))
							&& (MemoryVal.contains(pod) || MemoryVal2.contains(pod) || MemoryVal3.contains(pod));
					System.out.println("---isloaded----" + isloaded + "-podname-" + pod + "CPUval --" + CPUval + CPUval2
							+ CPUval3 + "MemoryVal--" + MemoryVal + MemoryVal2 + MemoryVal3);
				} while (!isloaded);
			}
			Thread.sleep(1000);
			commonMethods.takeSnapShot(chromedriver, screenshotlocation, pod, "computeResourcePod_" + namespace);
			System.out.println("Taking screenshot for compute resources service post loading - " + pod);
		} else {
			Thread.onSpinWait();
			Thread.sleep(1000);
			commonMethods.takeSnapShot(chromedriver, screenshotlocation, pod, "computeResourcePod_" + namespace);
			System.out.println("!!! Taking screenshot for service without waiting as no data- " + pod);
		}
		commonMethods.zoom(chromedriver, 1.0);
	}

	private static void serviceMetricsDashboard(WebDriver chromedriver, int Iteration, String pod, String namespace)
			throws Exception {

		memoryHeapScreenshot(chromedriver, Iteration, pod, namespace);
		tomcatScreenshot(chromedriver, Iteration, pod, namespace);
		c3poScreenshot(chromedriver, Iteration, pod, namespace);
		hikariScreenshot(chromedriver, Iteration, pod, namespace);

	}

	private static void memoryHeapScreenshot(WebDriver chromedriver, int Iteration, String pod, String namespace)
			throws Exception {
		/*
		 * commonMethods.scroll(chromedriver, 60); System.out.println("Iteration " +
		 * Iteration + "namespace " + namespace); if (Iteration == 0 &&
		 * namespace.equalsIgnoreCase("Global")) { System.out.println("Iteration " +
		 * Iteration + "namespace " + namespace);
		 * commonMethods.getElementByXpath(chromedriver, 1000,
		 * elements.SQLcollapse).click(); System.out.println("sql collapse clicked");
		 * Thread.sleep(3000); commonMethods.getElementByXpath(chromedriver, 1000,
		 * elements.CPUProcessCollapse).click(); Thread.sleep(1000);
		 * 
		 * }
		 */

		// getting screenshot of memory heap
		new WebDriverWait(chromedriver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.MemoryMetricsDropdown)));
		commonMethods.getElementByXpath(chromedriver, 1000, elements.MemoryMetricsDropdown).click();
		if (commonMethods.isElementavailable(elements.MemoryMetricsPod1Name, chromedriver)
				&& commonMethods.isElementavailable(elements.MemoryMetricsPod2Name, chromedriver)) {
			commonMethods.zoom(chromedriver, 0.67);
			Thread.sleep(1500);
			new WebDriverWait(chromedriver, 10)
					.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.MemoryMetricsPod1Name)));
			new WebDriverWait(chromedriver, 10)
					.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.MemoryMetricsPod2Name)));
			commonMethods.takeSnapShot(chromedriver, screenshotlocation, pod, "serviceMetricsMemory_" + namespace);
			System.out.println("Taking screenshot for serviceMetricsMemory post loading - " + pod);
		}

		// collapse memory heap
		commonMethods.zoom(chromedriver, 1.0);
		Thread.sleep(1000);
		new WebDriverWait(chromedriver, 50)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.MemoryMetricsDropUp)));
		Thread.sleep(1000);
		commonMethods.getElementByXpath(chromedriver, 1000, elements.MemoryMetricsDropUp).click();
	}

	private static void tomcatScreenshot(WebDriver chromedriver, int Iteration, String pod, String namespace)
			throws Exception {
		// expand tomcat graph
		commonMethods.scroll(chromedriver, 0);
		// new WebDriverWait(chromedriver, 10)
		// .until(ExpectedConditions.elementToBeClickable(By.xpath(elements.TomcatThreadsDropdown)));
		// Thread.sleep(1000);
		commonMethods.getElementByXpath(chromedriver, 1000, elements.TomcatThreadsDropdown).click();
		commonMethods.scroll(chromedriver, 50);
		// click on active for all pods
		if (commonMethods.isElementavailable(elements.activeButton1, chromedriver)) {
			new WebDriverWait(chromedriver, 20)
					.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.activeButton1)));
			WebElement activeButton1 = chromedriver.findElement(By.xpath(elements.activeButton1));
			WebElement myElement = new WebDriverWait(chromedriver, 20)
					.until(ExpectedConditions.visibilityOf(activeButton1));
			((JavascriptExecutor) chromedriver).executeScript("arguments[0].scrollIntoView();", myElement);
			// System.out.println("scrolled to that view");
			commonMethods.getElementByXpath(chromedriver, 1000, elements.activeButton1).click();
		}

		if (commonMethods.isElementavailable(elements.activeButton2, chromedriver)) {
			new WebDriverWait(chromedriver, 10)
					.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.activeButton2)));
			commonMethods.getElementByXpath(chromedriver, 1000, elements.activeButton2).click();
		}
		// take screenshot tomcat
		commonMethods.zoom(chromedriver, 0.67);
		Thread.sleep(1000);
		commonMethods.takeSnapShot(chromedriver, screenshotlocation, pod, "serviceMetricsTomcat_" + namespace);
		System.out.println("Taking screenshot for serviceMetricsTomcat post loading - " + pod);

		// collapse TomcatThreadsDropUp
		commonMethods.zoom(chromedriver, 1.0);
		Thread.sleep(1000);
		new WebDriverWait(chromedriver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.TomcatThreadsDropUp)));
		commonMethods.getElementByXpath(chromedriver, 1000, elements.TomcatThreadsDropUp).click();

		commonMethods.zoom(chromedriver, 1.0);
	}

	private static void c3poScreenshot(WebDriver chromedriver, int Iteration, String pod, String namespace)
			throws Exception {
		// take c3po screenshot
		if (c3po.contains(pod)) {

			if (commonMethods.isElementavailable(elements.c3poDropdown, chromedriver)) {
				new WebDriverWait(chromedriver, 10)
						.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.c3poDropdown)));
				Thread.sleep(1000);
				commonMethods.getElementByXpath(chromedriver, 1000, elements.c3poDropdown).click();
			}
			commonMethods.scroll(chromedriver, 30);
			if (commonMethods.isElementavailable(elements.c3poBusyInput1, chromedriver)
					&& commonMethods.isElementavailable(elements.c3poBusyInput2, chromedriver)) {
				commonMethods.zoom(chromedriver, 0.67);
				Thread.sleep(1500);
				commonMethods.takeSnapShot(chromedriver, screenshotlocation, pod, "C3PO_" + namespace);
				System.out.println("Taking screenshot for C3poConnectionPool post loading - " + pod);
			}
			commonMethods.zoom(chromedriver, 1.0);
			if (commonMethods.isElementavailable(elements.c3poCollapse, chromedriver)) {
				new WebDriverWait(chromedriver, 10)
						.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.c3poCollapse)));
				Thread.sleep(1000);
				commonMethods.getElementByXpath(chromedriver, 1000, elements.c3poCollapse).click();
			}

		}
	}

	private static void hikariScreenshot(WebDriver chromedriver, int Iteration, String pod, String namespace)
			throws Exception {
		// take hikari screenshot
		if (hikari.contains(pod)) {

			if (commonMethods.isElementavailable(elements.hikariDropdown, chromedriver)) {
				new WebDriverWait(chromedriver, 10)
						.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.hikariDropdown)));
				Thread.sleep(2000);
				commonMethods.getElementByXpath(chromedriver, 1000, elements.hikariDropdown).click();
			}
			JavascriptExecutor js = (JavascriptExecutor) chromedriver;
			// Scroll down till the bottom of the page
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			commonMethods.scroll(chromedriver, 75);
			if (commonMethods.isElementavailable(elements.hikariTotalConnections1, chromedriver)
					&& commonMethods.isElementavailable(elements.hikariTotalConnections2, chromedriver)) {

				// click on active connection
				if (commonMethods.isElementavailable(elements.activeButtonHikari1, chromedriver)) {
					new WebDriverWait(chromedriver, 10)
							.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.activeButtonHikari1)));
					Thread.sleep(2000);
					commonMethods.getElementByXpath(chromedriver, 1000, elements.activeButtonHikari1).click();
				}
				if (commonMethods.isElementavailable(elements.activeButtonHikari2, chromedriver)) {
					new WebDriverWait(chromedriver, 10)
							.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.activeButtonHikari2)));
					Thread.sleep(2000);
					commonMethods.getElementByXpath(chromedriver, 1000, elements.activeButtonHikari2).click();
				}
				commonMethods.zoom(chromedriver, 0.67);
				Thread.sleep(1500);
				commonMethods.takeSnapShot(chromedriver, screenshotlocation, pod, "Hikari_" + namespace);
				System.out.println("Taking screenshot for Hikari post loading - " + pod);
			}
			commonMethods.zoom(chromedriver, 1.0);
			if (commonMethods.isElementavailable(elements.hikariCollapse, chromedriver)) {
				new WebDriverWait(chromedriver, 10)
						.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.hikariCollapse)));
				commonMethods.getElementByXpath(chromedriver, 1000, elements.hikariCollapse).click();
			}

		}
	}

}