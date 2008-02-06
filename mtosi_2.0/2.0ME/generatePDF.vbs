Sub WordConverter(sDocFile, sPDFFile)

  WScript.Echo "Converting : " + sDocFile

  Dim DPSDK : Set DPSDK = CreateObject("docuPrinter.SDK")

  Dim fso ' As FileSystemObject

  Set fso = CreateObject("Scripting.FileSystemObject")

  sDocFile = fso.GetAbsolutePathName(sDocFile)
  DPSDK.DocumentOutputFolder = fso.GetParentFolderName(sDocFile)

  ' Determine the output file
  If Len(sPDFFile)=0 Then
    sPDFFile = fso.GetBaseName(sDocFile) + ".pdf"
  End If

  If Len(fso.GetParentFolderName(sPDFFile))<>0 Then
    DPSDK.DocumentOutputFolder = fso.GetParentFolderName(sPDFFile)
  End If

   DPSDK.DocumentOutputName = sPDFFile

   DPSDK.DocumentOutputFormat = "PDF"

   DPSDK.HideSaveAsWindow = true
   DPSDK.DefaultAction=1
 
   DPSDK.ApplySettings
 
   Dim DPWORD : Set DPWORD = CreateObject("docuPrinter.WordMacro")
   DPWORD.CHBookmarks=true
   DPWORD.CInternetLink=true
   DPWORD.CCrosRef=true
   DPWORD.CCrosDoc=true
   DPWORD.LinkFootEnd=true
   DPWORD.CWordTextBox=true
   DPWORD.CDocInfo=true
   DPWORD.CBookNameDest=true
   DPWORD.CComNotes=true    

   Dim RVal : RVal = DPWORD.ConvertDocument(sDocFile)
 
   Set DPWORD = Nothing
   Set DPSDK = Nothing

   If (RVal <> 0) Then 
     WScript.Echo "Error while converting the document : " + sDocFile
   Else
     WScript.Echo "Done, File : " + sPDFFile + " created"
   End If
 
End Sub

'ProductDescription
Call WordConverter("ProductDescription\RN306_MTOSI_Release2.0BA.doc", "") 

'Framework
Call WordConverter("DDPs\Framework\BA\TMF518_FMW.doc", "")
Call WordConverter("DDPs\Framework\SD\SD1-6_ContainedTPs.doc", "")
Call WordConverter("DDPs\Framework\SD\SD1-8_encodingX731M3100.doc", "")
Call WordConverter("DDPs\Framework\SD\SD1-14_IMOverview.doc", "")
Call WordConverter("DDPs\Framework\SD\SD1-16_LayeredParameters.doc", "")
Call WordConverter("DDPs\Framework\SD\SD1-17_LayerRates.doc", "")
Call WordConverter("DDPs\Framework\SD\SD1-18_layers.doc", "")
Call WordConverter("DDPs\Framework\SD\SD1-19_LocationIdentification.doc", "")
Call WordConverter("DDPs\Framework\SD\SD1-20_MaintenanceCommands.doc", "")

'Call WordConverter("DDPs\Framework\SD\SD1-22_modelDiagramComponents.ppt", "")
'manually generated for now
WScript.Echo "Converting : " + "DDPs\Framework\SD\SD1-22_modelDiagramComponents.ppt"
WScript.Echo "Done, File : " + "DDPs\Framework\SD\SD1-22_modelDiagramComponents.pdf" + " created"

Call WordConverter("DDPs\Framework\SD\SD1-28_PerformanceParameters.doc", "")
Call WordConverter("DDPs\Framework\SD\SD1-33_ProbableCauses.doc", "")
Call WordConverter("DDPs\Framework\SD\SD1-36_SNCTypes.doc", "")
Call WordConverter("DDPs\Framework\SD\SD1-44_ConnectionlessTechnologyManagement.doc", "")
Call WordConverter("DDPs\Framework\SD\SD2-0_mTOPDictionary.doc", "")

'ManageResourceInventory
Call WordConverter("DDPs\ManageResourceInventory\BA\TMF518_MRI.doc", "")
Call WordConverter("DDPs\ManageResourceInventory\SD\SD2-14_AVC_SC_Notifications.doc", "")

'NetworkResourceAssurance
Call WordConverter("DDPs\NetworkResourceAssurance\BA\TMF518_NRA.doc", "")
Call WordConverter("DDPs\NetworkResourceAssurance\SD\SD1-37_TCAs.doc", "")

'NetworkResourceBasic
Call WordConverter("DDPs\NetworkResourceBasic\BA\TMF518_NRB.doc", "")
Call WordConverter("DDPs\NetworkResourceBasic\SD\SD2-17_MTOSI_EnhancedResourceStates.doc", "")

'NetworkResourceFulfillment
Call WordConverter("DDPs\NetworkResourceFulfillment\BA\TMF518_NRF.doc", "")
Call WordConverter("DDPs\NetworkResourceFulfillment\SD\SD2-12_MTOSI_Inventory_Layout.doc", "")

'ResourcePerformanceManagement
Call WordConverter("DDPs\ResourcePerformanceManagement\BA\TMF518_RPM.doc", "")
Call WordConverter("DDPs\ResourcePerformanceManagement\SD\SD1-30_PMFileFormat.doc", "")
'manually generated for now
WScript.Echo "Converting : " + "DDPs\ResourcePerformanceManagement\SD\SD1-31_PMExample.txt"
WScript.Echo "Done, File : " + "DDPs\ResourcePerformanceManagement\SD\SD1-31_PMExample.pdf" + " created"
'manually generated for now
WScript.Echo "Converting : " + "DDPs\ResourcePerformanceManagement\SD\SD1-32_PMExample.xls"
WScript.Echo "Done, File : " + "DDPs\ResourcePerformanceManagement\SD\SD1-32_PMExample.pdf" + " created"

'ResourceProvisioning
Call WordConverter("DDPs\ResourceProvisioning\BA\TMF518_RP.doc", "")
' Call WordConverter("DDPs\ResourceProvisioning\SD\", "")

'ResourceTroubleManagement
Call WordConverter("DDPs\ResourceTroubleManagement\BA\TMF518_RTM.doc", "")
' Call WordConverter("DDPs\ResourceTroubleManagement\SD\", "")

'ServiceActivation
Call WordConverter("DDPs\ServiceActivation\BA\Part1\TMF518_SA_1.doc", "")
Call WordConverter("DDPs\ServiceActivation\BA\Part2\TMF518_SA_2.doc", "")
Call WordConverter("DDPs\ServiceActivation\BA\Part3\TMF518_SA_3.doc", "")
Call WordConverter("DDPs\ServiceActivation\SD\", "")

'ServiceBasic
Call WordConverter("DDPs\ServiceBasic\BA\TMF518_SB.doc", "")
'Call WordConverter("DDPs\ServiceBasic\SD\SD2-18_VPNServiceModel.xls", "")
WScript.Echo "NOT Converting : " + "DDPs\ServiceBasic\SD\SD2-18_VPNServiceModel.xls"
WScript.Echo "Done, File : " + "DDPs\ServiceBasic\SD\SD2-18_VPNServiceModel.xls" + " unchanged"


