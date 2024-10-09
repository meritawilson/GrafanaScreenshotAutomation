package com.grafanaScereenshot.dashboardScreenshot;

import org.openqa.selenium.WebElement;

public class elements {
	// static String screenshotLocation =
	// "C:\\Users\\mewilson\\eclipse-workspace\\automationtest\\dashboardScreenshot\\screenshot";
	static String wrongPodSubString = "iics-tools";
	static String signUpWithOKTA_Button = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/a[1]/span[1]";
	static String grafanaUrl = "https://grafananp.cloudtrust.rocks/d/6581e46e4e5c7ba40a07646395ef7b2/kubernetes-compute-resources-pod?orgId=1&var-datasource=aws-uswest2&var-cluster=iicsqa-uswest2-kube-controlplane&var-namespace=iics-qa-perfusw1&var-interval=4h&var-container=All&from=1677489673158&to=1677489860336";
	static String oktaUsername = "/html[1]/body[1]/div[2]/div[1]/main[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]";
	static String oktaPassword = "/html[1]/body[1]/div[2]/div[1]/main[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[2]/span[1]/input[1]";
	static String oktaSignIn = "/html[1]/body[1]/div[2]/div[1]/main[1]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]";
	// computeResources
	static String CPUusage = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[13]/div[1]/div[1]/div[2]/h6[1]";
	static String KCRPMemoryQuota = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[17]/div[1]/div[1]/div[2]/h6[1]";
	// static String istio_proxy =
	// "/html[1]/body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[16]/div[1]/div[1]/div[2]/div[1]/plugin-component[1]/panel-plugin-table-old[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[1]";
	static String scrollbutton = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]";
	static String networkDropdown = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[18]/div[1]/button[1]";

	static String transmitBandwidth = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[20]/div[1]/div[1]/div[2]/h6[1]";

	// //body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[4]/div[1]/div[1]/button[1]
	static String podInput = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[4]/div[1]/div[1]/button[1]";
	static String podInputPoint = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/input[1]";

	static String podElement1 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]";
	static String podElement2 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/button[1]";
	static String podElement3 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/button[1]";
	static String podElement4 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/button[1]";
	static String podElement5 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/button[1]";
	static String podElement6 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/button[1]";

	static String clusterInputPoint = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]";
	static String clusterpodElement1 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]";
	static String clusterInput = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[2]/div[1]/div[1]/button[1]";

	static String namespaceInputPoint = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/input[1]";
	static String namespaceInput = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[3]/div[1]/div[1]/button[1]";
	static String namespacepodElement1 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]";

	static String receiveBandwidthText = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[19]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]/div[1]/button[1]";
	static String trasmitBandwidthText = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[20]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]/div[1]/button[1]";

	static String memoryQuotaConatinerName = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[17]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]";
	static String memoryQuotaConatinerName2 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[17]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]";
	static String memoryQuotaConatinerName3 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[17]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]";

	static String CPUQuotaConatinerName = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[16]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]";
	static String CPUQuotaConatinerName2 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[16]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]";
	static String CPUQuotaConatinerName3 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[16]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]";

	static String podInputServiceMetrics = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[3]/div[1]/div[1]/button[1]/span[1]";
	static String podInputPointServiceMetrics = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/input[1]";
	static String podElement1ServiceMetrics = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]";
	static String DeploymentInputServiceMetrics = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[2]/div[1]/div[1]/button[1]";
	static String DeploymentInputServiceMetricsInputPoint = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/input[1]";
	static String DeploymentInputServiceMetricsElement1 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]";
	static String MemoryMetricsDropdown = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[16]/div[1]/button[1]";
	static String TomcatThreadsDropdown = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[22]/div[1]/button[1]";

	static String c3poDropdown = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[24]/div[1]/button[1]";
	static String hikariDropdown = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[25]/div[1]/button[1]";
	static String c3poTotalConnections1 = "	//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[27]/div[1]/div[1]/div[2]/h6[1]";
	static String c3poTotalConnections2 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[28]/div[1]/div[1]/div[2]/h6[1]";
	static String c3poBusyInput1 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[25]/div[1]/div[1]/div[3]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]";
	static String c3poBusyInput2 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[26]/div[1]/div[1]/div[3]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]";
	static String hikariTotalConnections1 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[40]/div[1]/div[1]/div[3]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[1]";
	static String hikariTotalConnections2 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[41]/div[1]/div[1]/div[3]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[1]";
	static String MemoryMetricsDropUp = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[30]/div[1]/button[1]";
	static String TomcatThreadsDropUp = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[22]/div[1]/button[1]";
	static String SQLcollapse = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[14]/div[1]/button[1]";
	static String CPUProcessCollapse = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[15]/div[1]/button[1]";
	static String c3poCollapse = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[24]/div[1]/button[1]";
	static String hikariCollapse = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[25]/div[1]/button[1]";

	static String NodataCPU = "//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[16]/div[1]/div[1]/div[2]/div[1]/plugin-component[1]/panel-plugin-table-old[1]/grafana-panel[1]/ng-transclude[1]/div[2]/span[1]";
	static String NodataMemory = "//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[17]/div[1]/div[1]/div[2]/div[1]/plugin-component[1]/panel-plugin-table-old[1]/grafana-panel[1]/ng-transclude[1]/div[2]/span[1]";
	static String heapUsage1 = "//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[17]/div[1]/div[1]/div[2]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]";
	static String heapUsage2 = "//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[18]/div[1]/div[1]/div[2]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]";
	static String heapUsage3 = "//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[19]/div[1]/div[1]/div[2]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]";
	static String heapUsage4 = "//body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[20]/div[1]/div[1]/div[2]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]";
	static String MemoryMetricsPod1Name = "//body[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[17]/div[1]/div[1]/div[3]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]";
	static String MemoryMetricsPod2Name = "//body[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[18]/div[1]/div[1]/div[3]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]";
	static String activeButton1 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[23]/div[1]/div[1]/div[3]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/button[1]";
	static String activeButton2 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[24]/div[1]/div[1]/div[3]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/button[1]";
	static String activeButton3 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[25]/div[1]/div[1]/div[3]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/button[1]";
	static String activeButtonHikari1 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[26]/div[1]/div[1]/div[3]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]";
	static String activeButtonHikari2 = "//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[27]/div[1]/div[1]/div[3]/div[1]/plugin-component[1]/panel-plugin-graph[1]/grafana-panel[1]/ng-transclude[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]";
}