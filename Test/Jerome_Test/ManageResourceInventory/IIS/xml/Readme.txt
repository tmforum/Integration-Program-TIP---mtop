This folder contains sample files of MTOSI Release 2.0 SOAP messages based on new MEP proposal, which is part of the latest NGOSS WS interface guidelines:

Asynchronous (MSG):
  RequestResponse (ARR)
  - 1-1_arr_getManagedElementRequest.xml
  - 1-2_arr_getManagedElementResponse.xml
  - 1-3_arr_getManagedElementException.xml

  RR with BatchNotification (ABN)
  - 2-1_abn_getAllManagedElementsWithBatchNotificationRequest.xml
  - 2-2_abn_getAllManagedElementsWithBatchNotificationResponse.xml
  - 2-3_abn_getAllManagedElementsWithBatchNotificationException.xml
  - 2-4_abn_notifygetAllManagedElementsWithBatchNotificationEvent.xml (this is the notification event with a batch of data included using the MTOSI NotificationConsumer. WSN Notification Consumer could also be used as well)

  RR with File Transfer (AFT)
  - 3-1_aft_getInventoryWithFileTransferRequest.xml
  - 3-2_aft_getInventoryWithFileTransferResponse.xml
  - 3-3_afb_getInventoryWithFileTransferException.xml

  RR with Iterator (AIT)
  - 4-1_ait_getInventoryWithIteratorRequest.xml
  - 4-2_ait_getInventoryWithIteratorResponse.xml
  - 4-3_ait_getInventoryWithIteratorException.xml

Synchronous (RPC):
  RequestResponse (SRR)
  - 5-1_srr_getManagedElementRequest.xml
  - 5-2_srr_getManagedElementResponse.xml
  - 5-3_srr_getManagedElementException.xml

  RR with Iterator (SIT)
  - 6-1_sit_getAllManagedElementsWithIteratorRequest.xml
  - 6-2_sit_getAllManagedElementsWithIteratorResponse.xml
  - 6-3_sit_getAllManagedElementsWithIteratorException.xml
  - 6-4_sit_getNextRequest.xml
  - 6-5_sit_getNextResponse.xml
  - 6-6_sit_cancelRequest.xml
  - 6-7_sit_cancelResponse.xml

  RR with BatchNotification (SBN)
  - 7-1_sbn_getInventoryWithBatchNotificationRequest.xml
  - 7-2_sbn_getInventoryWithBatchNotificationResponse.xml
  - 7-3_sbn_getInventoryWithBatchNotificationException.xml
  - 7-4_sbn_notifygetInventoryWithBatchNotificationEvent.xml (same as 2-4)

  RR with File Transfer (SFT)
  - 8-1_sft_getInventoryWithFileTransferRequest.xml
  - 8-2_sft_getInventoryWithFileTransferResponse.xml
  - 8-3_sft_getInventoryWithFileTransferException.xml

batchfile_getInventoryWithFileTransfer.xml (thisfile is commonto getInventory SFT or AFT)
