package ask.sec.magicinfo;


//package com.samsung.magicinfo.protocol.file;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.SocketException;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.UUID;
//
//import org.apache.log4j.Logger;
//import org.apache.xml.security.utils.Base64;
//import org.quartz.JobDetail;
//import org.quartz.SchedulerException;
//import org.quartz.SimpleTrigger;
//import org.quartz.Scheduler;
//
//import jcifs.UniAddress;
//import jcifs.smb.NtlmPasswordAuthentication;
//import jcifs.smb.SmbAuthException;
//import jcifs.smb.SmbException;
//import jcifs.smb.SmbFile;
//import jcifs.smb.SmbFileInputStream;
//import jcifs.smb.SmbSession;
//
//import com.samsung.common.config.CommonConfig;
//import com.samsung.common.logger.LoggingManager;
//import com.samsung.magicinfo.controller.content.ContentXmlManager;
//import com.samsung.magicinfo.framework.content.constants.ContentConstants;
//import com.samsung.magicinfo.framework.content.entity.Content;
//import com.samsung.magicinfo.framework.content.entity.ContentFile;
//import com.samsung.magicinfo.framework.content.manager.ContentInfo;
//import com.samsung.magicinfo.framework.content.manager.ContentInfoImpl;
//import com.samsung.magicinfo.framework.scheduler.manager.ScheduleInfo;
//import com.samsung.magicinfo.framework.scheduler.manager.ScheduleInfoImpl;
//import com.samsung.magicinfo.framework.user.entity.User;
//import com.samsung.magicinfo.framework.user.manager.UserInfo;
//import com.samsung.magicinfo.framework.user.manager.UserInfoImpl;
//import com.samsung.magicinfo.protocol.compiler.ConfigException;
//import com.samsung.magicinfo.protocol.constants.ServiceConstants;
//import com.samsung.magicinfo.protocol.scheduler.ScheduleManager;
//
//import java.awt.AlphaComposite;
//import java.awt.Graphics2D;
//import java.awt.RenderingHints;
//import java.awt.image.BufferedImage;
//import java.awt.image.Raster;
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.io.RandomAccessFile;
//import java.net.URL;
//import java.nio.ByteBuffer;
//import java.nio.CharBuffer;
//import java.nio.channels.Channels;
//import java.nio.channels.FileChannel;
//import java.nio.channels.ReadableByteChannel;
//import java.nio.charset.Charset;
//import java.nio.charset.CharsetEncoder;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.sql.SQLException;
//import java.text.NumberFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Iterator;
//
//import javax.imageio.ImageIO;
//import javax.imageio.ImageReader;
//import javax.imageio.stream.ImageInputStream;

/**
 * @author ASK
 * 
 */
//public class Cifs
//{
//
//	private Logger	logger	= LoggingManager.getLogger(CifsFilesToDownload.class);
//	
//	private Boolean inUse;
//	
//	private static Cifs instance;
//	
//	private Cifs()
//	{
//		this.inUse = Boolean.FALSE;
//	}
//	
//	public static Cifs getInstance()
//	{
//		if (instance == null)
//			instance = new Cifs();
//		return instance;
//	}
//
//	public boolean getCifsFiles(String miUserId, long groupId, String contentId, String cifsContentName, 
//											String cifsIP, String cifsLoginId, String cifsPassword, 
//											String localPathByIp, String cifsDirectory, long cifsRefreshInterval, boolean scheduledJob) 
//											throws SQLException 
//	{	
////		synchronized (this.inUse) 
//		{
////			while(this.inUse)
////			{
////				System.out.println("------- [CIFS] Wait : inUse "	
////						+ contentId + " " + cifsContentName + " " + scheduledJob);		
////				
////				try 
////				{			
////					wait(); 
////				} 
////				catch (InterruptedException e) 
////				{
////					logger.error(e);
////				}
////			}
//			
//	        boolean result = false;
//	        int reply = 0;
//            ContentInfo dao = ContentInfoImpl.getInstance();
//            
//	        try 
//	        {
//	        	this.inUse = Boolean.TRUE;
//	        
//	        	System.out.println("------- [CIFS] UPDATE_CIFS_CONTENT_SERVICE : "	
//	        						+ contentId + " " + cifsContentName + " " + scheduledJob);	        	
//	        	
//	    		String CONTENTS_HOME  = CommonConfig.get("CONTENTS_HOME").replace('/', File.separatorChar)+ 
//										File.separatorChar + ContentConstants.CONTENTS_DIR;
//	    		
//	            Content content  = new Content();	    		
//				UserInfo uInfo = UserInfoImpl.getInstance();
//				User user = new User();
//				boolean checkLogon = false;
//				boolean editMode = false; //in the case of already existing content
//				boolean settingChanged = false;
//				
////				System.out.println("---------------- P--------------------- " + cifsPassword);
//				if(scheduledJob)
//					cifsPassword = new String(Base64.decode(cifsPassword));
//				
//	            // TO-DO : connection check, login check
//				UniAddress domainController = UniAddress.getByName(cifsIP);
//	    		NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, cifsLoginId, cifsPassword);
////	    		System.out.println("---------------- P--------------------- " + cifsPassword);
//	    		
//				try 
//				{
//				    SmbSession.logon(domainController, auth);
//				    checkLogon = true;
//				    System.out.println("[CIFS_Thread] login success");				    
//				}
//				catch( SmbAuthException sae ) 
//				{
//				    // auth failure
//					checkLogon = false;
//					System.out.println("[CIFS_Thread] login failure");
//				} 
//				catch( SmbException se ) 
//				{
//				    // for n/w issue
//					checkLogon = false;
//				    System.out.println("[CIFS_Thread] login failure");					
//				    se.printStackTrace();
//				}	    		
//	    		
//				
//				// logon check
//				if(checkLogon)
//				{
//		    		String cifsFilePath  = "smb://" + cifsIP + cifsDirectory;
//		    		SmbFile dir = new SmbFile(cifsFilePath, auth);
//	
//		            if(dir != null && dir.listFiles().length > 0) 
//		            {
//		            	int count = 0;
//		            	long totalSizeOfFiles = 0l;
//		            	boolean fileChanged = false;
////						String contentId = UUID.randomUUID().toString();	            	
//						String mainFileId = UUID.randomUUID().toString();    // create new file
//
//	
//						String fileNameStyle = "CIFS_" 
//											+ cifsIP.replace('.', '_')
//											+ cifsLoginId
//											+ '_' + cifsDirectory.replace('/', '_');
//						
//						if(miUserId.equalsIgnoreCase(null) || miUserId.equalsIgnoreCase(""));
//							miUserId = "admin";					
//							
//						
//						// 1. File Compare & Get new file size
//			    		for (SmbFile smbFile : dir.listFiles())
//			    		{					
//			    			String smbFileName = smbFile.getName();
//							long newFileSize = smbFile.length();
//							long oldFileSize = 0;
//	//		    			long newFileHashCode = smbFile.hashCode();						
//	//						long oldFileHashCode = 0;
//							
//			    			File oldFile = null; 
//							String src = localPathByIp + File.separator + smbFileName;
//		
//							oldFile = new File(src);				
//							
//							if(oldFile.exists())
//							{
//								oldFileSize = oldFile.length();
//							}					
//		
//		                	String oldFileName = smbFileName;	  // fileNameStyle              	
//		                	String localFileHashCode = dao.getHashCodeFromContentByFileName(oldFileName, "CIFS_CONTENT");
//		                	
//		                	// only valid file type	                	             	
//		                	boolean validType = false; 
//		                	String[] tempName = smbFileName.split("[.]");  	                	
//		                	int sizeOfSplitedName = 0;
//	
//		                	if(tempName.length > 0)
//		                	{
//		                		sizeOfSplitedName = tempName.length - 1;
//	//			    		    System.out.println("[FTP file] ftpFileName " + tempName[sizeOfSplitedName]);	                		
//		                		validType = dao.getCodeFile(tempName[sizeOfSplitedName].toUpperCase()).equalsIgnoreCase("");  // !"" : true
//		                	}
//		                	
//							if(!validType)
//							{
//								if(!oldFile.exists() || localFileHashCode == null || 
//										((oldFileSize != newFileSize) && (smbFileName.equals(oldFile.getName()))))
//								{						
//									fileChanged = true;  // for file updating by period
//									System.out.println("[CIFS_Thread] Need to get new file : " + oldFile.getName());
//								}
//
//								totalSizeOfFiles += newFileSize;
//							}
//			    		}
//						
//			    		
//			    		// 2. Previous File Remover
//			    		List<ContentFile> preContentFileList = dao.getFileList(contentId);
//			    		
//			    		for(int i = 0; i < preContentFileList.size() ; i ++)
//			    		{
//			    			boolean existsServerFile = false;
//			    			String preContentFileName = preContentFileList.get(i).getFile_name();
//			    			
//				    		for (SmbFile smbFile : dir.listFiles())
//				    		{					
//				    			String smbFileName = smbFile.getName();
//				    			if(preContentFileName.equalsIgnoreCase(smbFileName))
//				    			{
//				    				existsServerFile = true;
////						    		System.out.println("Previous File Remover " + preContentFileName + " / " + smbFileName);				    				
//				    				break;
//				    			}
//				    		}
//
//				    		if(!existsServerFile && !preContentFileName.equalsIgnoreCase(ContentConstants.META_FILE_NAME_CIFS))
//				    		{
//				    			File preContentFile = null;
//				    			
//								System.out.println("[CIFS_Thread] Previous File Remover : del " + preContentFileName);				    			
//								String src = localPathByIp + File.separator + preContentFileName;
//								
//								preContentFile = new File(src);																    			
//								preContentFile.delete();
//								
//								dao.deleteFileByFileNameByContentId(contentId, preContentFileName);
//								
//								fileChanged = true;
//				    		}
//			    		}
//		    		
//			    		
//			    		// 3. EditMode Checker 			    		
//						List cifsInfo = dao.getCifsContentSettingByContentId(contentId);
//						
//						if(cifsInfo != null && cifsInfo.size() > 0)
//						{
//							editMode = true;
//							
//							HashMap cifsInfoValues = (HashMap)cifsInfo.get(0);
//							long oldValue = (Long)cifsInfoValues.get("refresh_interval");
//
//							if(oldValue != cifsRefreshInterval)
//							{
//								settingChanged = true;
//								System.out.println("[CDV_CIFS] editMode " + contentId + " " + oldValue + " " + cifsRefreshInterval);
//							}
//						}					
//						
//						// Get Main FileId
//						if(editMode) // editMode includes scheduledJob mode
//						{
//							// CHECK it again!
//							mainFileId = dao.getMainFileInfo(contentId).getFile_id();
//							
//							System.out.println("[CDV_CIFS] editMode : oldMainFile id = " + mainFileId);
//						}						
//			    		
//
//						// add new content : once
//						if(cifsContentName.equalsIgnoreCase(""))
//							cifsContentName = fileNameStyle;
//						
//						// for content DB only for CSD file
//			            content.setContent_id(contentId); 
//			            content.setCreator_id(miUserId);
//			            content.setContent_name(cifsContentName);
//			            content.setIs_deleted("N");
//			            content.setShare_flag(1);
//						content.setOrganization_id(uInfo.getRootGroupIdByUserId(miUserId));
//			            
//			            // for content_version DB only for CSD file
//						content.setVersion_id(0l);  // should be changed in editing 
//						content.setMedia_type("CIFS");
//						content.setThumb_file_id(ContentConstants.MEDIASLIDE_THUMBNAIL_ID);
//						content.setTotal_size(totalSizeOfFiles);  
//						content.setIs_active("N");
//						content.setMain_file_id(mainFileId); 
//						content.setIs_linear_vwl("N");
//						content.setScreen_count(0);
//						content.setContent_meta_data("");
//						content.setX_count(0);
//						content.setY_count(0);
//						content.setX_range(0);
//						content.setY_range(0);
//						content.setIs_streaming("N");
//						content.setMain_file_Extension(ContentConstants.MEDIA_TYPE_CIFS); 
//
//
//
//						System.out.println("[CIFS_Thread] isEdit/fileChanged/settingChanged" 
//											+ editMode + "/" + fileChanged + "/" + settingChanged);
//						
//						
//						////////////////  4-1. UPDATE DB  ////////////////
//
//						// update content : 2nd time by updating
//						if(editMode)  // including job 
//						{
//							if(fileChanged)
//							{
//								dao.updateContentVersionInfoByContentId(totalSizeOfFiles, contentId);
//							}
//							
//							if(settingChanged)
//							{	
//					            dao.updateCifsSettingByContentId(contentId, cifsContentName,  
//									            				cifsIP, cifsLoginId, Base64.encode(cifsPassword.getBytes()), 
//									            				cifsDirectory, cifsRefreshInterval); // only interval is valid
//							}
//						}
//						else // new
//						{
//				            dao.addContentInfo(content);
//				            dao.addContentVersionInfo(content);
//				            dao.addMapGroupContent(contentId, groupId);
//				            dao.addCifsSetting(contentId, cifsContentName, /*date*/ 
//					            				cifsIP, cifsLoginId, Base64.encode(cifsPassword.getBytes()), 
//					            				cifsDirectory, cifsRefreshInterval);				
//						}
//
//						
//						////////////////  4-2. DOWNLOAD START  ////////////////
//						
//						if(fileChanged)
//						{						
//							for(SmbFile smbFile : dir.listFiles())
//							{
//				    			String smbFileName = smbFile.getName();
//								long newFileSize = smbFile.length();
//								long oldFileSize = 0;
//		//		    			long newFileHashCode = smbFile.hashCode();						
//		//						long oldFileHashCode = 0;
//								
//				    			File oldFile = null; 
//								String src = localPathByIp + File.separator + smbFileName;
//			
//								oldFile = new File(src);				
//								
//								if(oldFile.exists())
//								{
//									oldFileSize = oldFile.length();
//								}					
//			
//			                	String oldFileName = smbFileName;	  //fileNameStyle +               	
//			                	String localFileHashCode = dao.getHashCodeFromContentByFileName(oldFileName, "CIFS_CONTENT");
//			                	
//								
//								String fileId = UUID.randomUUID().toString();
//		
//								if(count == 0)
//								{
//									//fileId = mainFileId; // only 1 time 
//								}
//								
//								if(!smbFile.isFile()) 
//								{
//									continue;
//							    }
//			
//			                	
//			                	// only valid file type	                	             	
//			                	boolean validType = false; 
//			                	String[] tempName = smbFileName.split("[.]");  	                	
//			                	int sizeOfSplitedName = 0;
//		
//			                	if(tempName.length > 0)
//			                	{
//			                		sizeOfSplitedName = tempName.length - 1;
//		//			    		    System.out.println("[FTP file] ftpFileName " + tempName[sizeOfSplitedName]);	                		
//			                		validType = dao.getCodeFile(tempName[sizeOfSplitedName].toUpperCase()).equalsIgnoreCase("");  // !"" : true
//			                	}
//			                	
//								if(!validType 
//									&& (!oldFile.exists() || localFileHashCode == null || 
//										((oldFileSize != newFileSize) && (smbFileName.equals(oldFile.getName())))))
//								{
//									System.out.println("[CIFS_Thread] Not exist or mismatched : " + smbFileName);
////									fileChanged = true;
//									
//									File contentHome = new File(CONTENTS_HOME + File.separator + fileId);
//									String dest = contentHome + File.separator + /*fileNameStyle + "_" + */smbFileName;
//					            
//						    		File cifsPathByIp = new File(localPathByIp);
//						    		if(!cifsPathByIp.exists()){
//						    			cifsPathByIp.mkdir();
//						    		}
//						    		
//						    		// not needed
//	//					    		File cifsContentHome = new File(localPathByIp + File.separator + smbFileName);
//	//								if(!cifsContentHome.exists()){
//	//									cifsContentHome.mkdir();
//	//								}							
//									
//						            File fileFromCIFS = new File(localPathByIp, smbFileName);
//						            
//						            FileOutputStream fos = null;
//						            
//						            try 
//						            {
//						            	fos = new FileOutputStream(localPathByIp + File.separator + smbFileName);
//						                int byteToDownload = 8192;
//						                
//	
//						                // Thread......
//						            	boolean isSuccess = false;
//						    			SmbFileInputStream sfis = new SmbFileInputStream(smbFile);
//						    			
//						    			byte[] b = new byte[byteToDownload];
//						    			int n = 0;
//						    			
//						    			while((n = sfis.read(b)) > 0)
//						    			{
//						    				fos.write(b, 0, n);
//						    			}
//				
//						    			fos.close();
//						    			sfis.close();					                
//						                
//						    			if(new File(localPathByIp + File.separator + smbFileName).isFile())
//						    				isSuccess = true;
//						    			
//						                // COPY
//						                if(isSuccess) 
//						                {
//						                	// HASH CHECK
//						                	String cifsFileHashCode = getHash(fileFromCIFS);				                	
//						                	boolean hashCheck = false;
//						                	
//	//					                	if(oldFile.exists())
//	//					                	{
//	//						                	if(localFileHashCode != null)
//	//						                	{
//	//						                		if(ftpFileHashCode.equalsIgnoreCase(localFileHashCode))
//	//						                			hashCheck = true;
//	//						                	}
//	//					                	}
//						                	
//						                	// UPDATE BY HASH CHECK
//						                	if(!hashCheck)
//						                	{	
//							                	// CREATE FOLDER for CONTENT
//												if(!contentHome.exists())
//												{
//													contentHome.mkdir();
//													FileOutputStream tempTrargetFos = new FileOutputStream(dest);
//													tempTrargetFos.close();
//												}
//		
//												
//												// COPY
//												// src, target
//												System.out.println("[CIFS_Thread] copy_src : " + src);
//												System.out.println("[CIFS_Thread] copy_dest : " + dest);
//												
//												copyDirectory(new File(src), new File(dest));
//												
//												// DATABASE 
//									            // add info to DB
//		
//									            ContentFile contentFile = new ContentFile();
//												
//												// for file DB 
//												contentFile.setFile_id(fileId);
//												contentFile.setFile_name(smbFileName);
//												contentFile.setFile_size(new File(dest).length());
//												contentFile.setFile_path(CONTENTS_HOME + File.separator + fileId);
//												contentFile.setHash_code(cifsFileHashCode);
//												contentFile.setCreator_id(miUserId);
//												contentFile.setFile_type("CIFS_CONTENT");
//												contentFile.setIs_streaming("N");
//												
//												dao.addFile(contentFile);
//												
//												long ver = 0l;										
//												ver = dao.getVersionInfoByContentId(content.getContent_id());
//												
//									            dao.addMapContentFile(contentId, ver, fileId);							
//						                	
//							                } 
//							                else 
//							                {
//							                    System.out.println("[CIFS_Thread] The hash value is matched " + smbFileName + " " + newFileSize);
//							                }				                	
//					                	}
//						                else
//						                {
//						                	System.out.println("[CIFS_Thread] Failed to get file from FTP " + smbFileName + " " + newFileSize);
//						            	}
//		
//						            } 
//						            catch(IOException ioe) 
//						            {
//						            	ioe.printStackTrace();
//						            } 
//						            finally 
//						            {
//						                if (fos != null)
//						                {
//						                	try 
//						                	{ 
//						                		fos.close(); 
//						                	} 
//						                	catch(IOException ex)
//						                	{
//						                		ex.printStackTrace();
//						                	}
//						                }
//						            }
//									count++;
//								}
//								else
//								{
//									System.out.println("[CIFS_Thread] The same file exists " + smbFileName + " " + newFileSize);
//								} 
//							}					
//		
//							System.out.println("[CIFS_Thread] Count for update / editMode / fileChanged = " 
//												+ count + " / " + editMode + " / " + fileChanged);
////						}
//						
// 
//						////////////////  5. Create CSD file  ////////////////							
////						if(fileChanged)
////						{
//	
//							List fileList = dao.getFileListByContentId(contentId);
//							
//							long version = 0l;										
//							version = dao.getVersionInfoByContentId(contentId) + 1;
//							
//							content.setVersion_id(version);
//													
//							// remove previous CSD & CIFS
//							File csdFolder = new File(CONTENTS_HOME + File.separator + "contents_meta" +File.separator + contentId);
//							
//							if(csdFolder.exists())
//							{
//								File csdFolderOldFile = new File(CONTENTS_HOME + File.separator + "contents_meta" + 
//														File.separator + contentId + File.separator + ContentConstants.META_FILE_NAME_CSD);
//								//deleteDirectoryRecursive(csdFolderOldFile);
//								csdFolderOldFile.delete();
//							}							
//
//							
//							// Create CSD
//							File csdFile = createCSD(content, fileList);
//	
//							// replica of CSD
//							if(csdFile.exists())
//							{
////								String cifsFileHashCode = getHash(csdFile);	
//								String srcFile = CONTENTS_HOME + File.separator + "contents_meta" + 
//										File.separator + contentId + File.separator + ContentConstants.META_FILE_NAME_CSD;
//
//								// New Main File
//								ContentFile contentFile = new ContentFile();
//								String hashCode = "";
//								long fileSize = 0l;								
//								String newMainFileId = UUID.randomUUID().toString().toUpperCase();
//								String newFilePath = CONTENTS_HOME + File.separator + newMainFileId;
//								String newFilePathFile = CONTENTS_HOME + File.separator + newMainFileId + File.separator + ContentConstants.META_FILE_NAME_CIFS;
//								File newMetaFile = new File(newFilePathFile);
//								
//								File fileCmsFile = new File(newFilePath);
//								if (!fileCmsFile.exists()) {
//									fileCmsFile.mkdir();
//								}								
//
//								System.out.println("[CIFS_Thread] csd_src : " + srcFile);
//								System.out.println("[CIFS_Thread] csd_dest : " + newFilePathFile);
//																
//								copyFile(new File(srcFile), newMetaFile);	
//								
//								hashCode = dao.getHash(newMetaFile);
//								fileSize = newMetaFile.length();								
//								
//								// for file DB
//								contentFile.setFile_id(newMainFileId);
//								contentFile.setFile_name(ContentConstants.META_FILE_NAME_CIFS);
//								contentFile.setFile_size(fileSize);
//								contentFile.setFile_path(newFilePath);
//								contentFile.setHash_code(hashCode);
//								contentFile.setCreator_id(miUserId);
//								contentFile.setFile_type("CIFS_MAIN");
//								contentFile.setIs_streaming("N");
//	
//								
//								// add csd file info
////								if(!editMode)  // old concept
//								// for file update, use updateFile with last_modified_date or del prev file and get again
//								{
//									dao.addFile(contentFile);							
//								}
//								
//								// Update DB again, in content version : pkey version
//								System.out.println("[CIFS_Thread] updateContentVersionInfoWithFileId : " + newMainFileId + "  "+ version);
//					            dao.updateContentVersionInfoWithFileId(contentId, newMainFileId, version);
//					            
//					            // hashCode in file : not needed
////					            dao.updateHashCodeByMainFileId(newMainFileId, fileSize, hashCode);	
//					            
////					            if(!editMode)  // old concept
//					            // for file update, use updateFile with last_modified_date or del prev file and get again
//					            {
//						            // fkey version 
//						            dao.addMapContentFile(contentId, version, newMainFileId);	
//					            }
//					            
//							}
//							
//							// Active in content version table after finishing jobs
//							dao.setIsActive(contentId, "Y");
//							System.out.println("[CIFS_Thread] Updated CSD & DB");					
//						}
//						else
//						{
//							System.out.println("[CIFS_Thread] Couldn't Update CSD and update DB");
//						}
//						
//						
//			            //////// 6. Update job scheduling ////////
//						
//						if(!editMode || settingChanged || fileChanged)
//			            {			            
//				    		Scheduler scheduler = ScheduleManager.getSchedulerInstance();
//				    		int startingDelay = 3;
//							String schedulerJobName = "CIFS_" + contentId; 
//							String schedulerJobGroup = ServiceConstants.UPDATE_CIFS_CONTENT_SERVICE;	
//							
//							try 
//							{
//								scheduler.deleteJob(schedulerJobName, schedulerJobGroup);
//							} 
//							catch (SchedulerException e) 
//							{
//								logger.error(e);
//							}	
//							System.out.println("[JobScheduling] UPDATE_CIFS_CONTENT_SERVICE : "
//									+ schedulerJobName + " " + cifsRefreshInterval);
//							
//							if(cifsRefreshInterval > 0)
//							{	
//								JobDetail jobdetail = null;
//								jobdetail = new JobDetail(schedulerJobName, schedulerJobGroup, CifsContentScheduleJob.class);
//			
//								Calendar currTime = Calendar.getInstance();
//								currTime.add(Calendar.MINUTE, startingDelay);
//			
//								SimpleTrigger trigger = 
//									new SimpleTrigger(schedulerJobName,	schedulerJobGroup, currTime.getTime(), null,
//										SimpleTrigger.REPEAT_INDEFINITELY, cifsRefreshInterval* 60L * 1000L);
//			
//								try 
//								{
//									scheduler.scheduleJob(jobdetail, trigger);
//								} 
//								catch (SchedulerException e) 
//								{
//									logger.error(e);
//								}
//								
//								// 1) schedule triggering
//								System.out.println("[CIFS] Start to schedule");
//								ScheduleInfo schInfo = ScheduleInfoImpl.getInstance();
//								schInfo.setContentTrigger(contentId);
//							}
//							else
//							{
//								System.out.println("[JobScheduling] UPDATE_CIFS_CONTENT_SERVICE : refresh_interval is 0");
//							}	
//							
//							
//							// 2) for triggering MediaSlide on DLK 
//							if(fileChanged)
//							{
//								List dlkContentList = null;
////								dlkContentList = dao.getDlkContentIdByTemplateId(contentId);
//								String inputDataContentId = contentId; // for caution!
//								dlkContentList = dao.getDlkContentIdByIputDataContentId(inputDataContentId);
//							
//								if(dlkContentList != null && dlkContentList.size() > 0)
//								{
//									for(int i=0; i < dlkContentList.size(); i++)
//									{
//										ContentXmlManager contentXmlManager = new ContentXmlManager();							
//										HashMap  dlkContent = (HashMap)dlkContentList.get(i);
//										String dlkContentId = dlkContent.get("DLK_CONTENT_ID").toString();
//										long nextVersion = dao.getContentNextVer(dlkContentId); 
//										String strVersionID = String.valueOf(nextVersion); // need to check
//										
//										// File change
//										String dlkMainFileId = dao.getMainFileInfo(dlkContentId).getFile_id();
//										String newDlkMainFileId = UUID.randomUUID().toString().toUpperCase();
//										String prevMediaSlideMainFileId = mainFileId;
//										String mediaSlideMainFileId = dao.getMainFileInfo(inputDataContentId).getFile_id();
////												dao.getFileInfoByContentIdVersionId(inputDataContentId, strVersionID); // updated one
//										
//										// Previous Main File
//										ContentFile dlkFile = dao.getFileInfo(dlkMainFileId);
//										String dlkFilePath = dlkFile.getFile_path()	+ File.separator + dlkFile.getFile_name();
//										
//										ContentFile mediaSlideFile = dao.getFileInfo(mediaSlideMainFileId);
//										
//										System.out.println("[CIFS] New mediaSlideFile ID "+ mediaSlideFile.getFile_id());
//										System.out.println("[CIFS] dlkContentId/inputDataContentID/strVersionID/nextVersion : " 
//												+ dlkContentId + "/" + inputDataContentId + "/" + strVersionID + "/" + nextVersion);
//										
//										// New Main File
//										ContentFile contentDlkFile = new ContentFile();
//	
//										String newDlkFilePath = CONTENTS_HOME + File.separator + newDlkMainFileId;
//										String newDlkFilePathFile = CONTENTS_HOME + File.separator + newDlkMainFileId + File.separator + dlkFile.getFile_name();
//										
//										File fileCmsFile = new File(newDlkFilePath);
//										if (!fileCmsFile.exists()) {
//											fileCmsFile.mkdir();
//										}	
//										
//										// create new file					
//										contentXmlManager.modifyMediaSlideInfo(prevMediaSlideMainFileId, mediaSlideFile, dlkFilePath, newDlkFilePathFile, 
//																				nextVersion, contentId, dlkContentId);	
//										
//										contentDlkFile.setFile_id(newDlkMainFileId);
//										contentDlkFile.setFile_path(newDlkFilePath);
//										contentDlkFile.setFile_name(dlkFile.getFile_name());
//										contentDlkFile.setCreator_id(miUserId);//userContainer.getUser().getUser_id());
//										contentDlkFile.setFile_type(ContentConstants.MEDIA_TYPE_TEMPLATE_CONTENT_EXTENSION);
//										contentDlkFile.setFile_size(dlkFile.getFile_size()); // temp							
//										
//										String hashCode = "";
//										long fileSize = 0l;
//										hashCode = dao.getHash(new File(newDlkFilePathFile));
//										fileSize = new File(newDlkFilePathFile).length();
//	
//										// add new file info
//										dao.addFile(contentDlkFile);
//										
//										// thumbnail_file id in content version
////										dao.updateThumbnailIdOfDlkByContentId(contentId, strVersionID, dlkContentId);   // templateid, ver, dlkid
//										
//										// hashCode in file
//										System.out.println("[CIFS] updateHashCodeByMainFileId " + dlkMainFileId + " " + hashCode + " " + fileSize);	
//										dao.updateHashCodeByMainFileId(newDlkMainFileId, fileSize, hashCode);							
//										
//										// version up in content version
//										dao.updateVersionAndMainFileIdInContentVersionInfo(nextVersion, newDlkMainFileId, dlkContentId);
//										
//										// update sch.
//										System.out.println("[CIFS] Start to schedule");
//										ScheduleInfo schInfo = ScheduleInfoImpl.getInstance();
//										schInfo.setContentTrigger(dlkContentId);
//									}
//								}// end of mediaSlide triggering						
//							}
//			            } // end of job scheduling						
//		            }
//		            else
//		            {
//		            	System.out.println("[CIFS] No files in Server");
//		            }
//				}
//	            // log out
//				 //jcifs.smb.client.soTimeout.
//	            
////				this.inUse = Boolean.FALSE;
////				notify();	            
//	        } 
//	        catch (IOException ioe) 
//	        {
//	        	ioe.printStackTrace();
//	        } 
//	        catch (Exception e) 
//	        {
//	        	e.printStackTrace();
//	        } 
//	        finally 
//	        {
//	        	result = true;
//	        	
//	        	dao.setIsReadyForNextCifsThread("Y", contentId);
//		        System.out.println("[CIFS] Finalize CIFS/inUse/setIsReady : " + result + "/" + this.inUse);
//	        }
//	        
//	        return result;  // not used yet
//	    }	
//	}	
//	
//
//
//	public File createCSD(Content content, List fileList) throws ConfigException//, String ftpIP, String userId, String ftpPath) 
//	{
//        ContentInfo dao = ContentInfoImpl.getInstance();
//        
//		try 
//		{
//			String CONTENTS_HOME  = CommonConfig.get("CONTENTS_HOME").replace('/', File.separatorChar)+ 
//									File.separatorChar + ContentConstants.CONTENTS_DIR; 			
//			String contentId = content.getContent_id();
//			
//			
//			File metaFolder = new File(CONTENTS_HOME + File.separator + "contents_meta");
//			if(!metaFolder.exists())
//				metaFolder.mkdir();
//			
//			File csdFolder = new File(CONTENTS_HOME + File.separator + "contents_meta" +File.separator + contentId);			
//			if(!csdFolder.exists())
//				csdFolder.mkdir();
//			
//			System.out.println("createCSD " + contentId );
//			
//			File csdFile = new File(CONTENTS_HOME + File.separator + "contents_meta" + 
//								File.separator + contentId + File.separator + ContentConstants.META_FILE_NAME_CSD);
//			
//			if (!csdFile.exists()) {
//				if (!csdFile.createNewFile()) {
//					return null;
//				}
//			}
//
//			String contentType = content.getMedia_type();
//
//			StringBuffer sb = new StringBuffer("");
//			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
//			sb.append("<CIFSContent cid=\"").append(content.getContent_id()).append(
//					"\">\n");
//			sb.append("  <User>").append(content.getCreator_id())
//					.append("</User>\n");
//			sb.append("  <Title>").append(content.getContent_name()).append(
////					common.ChangeSpecialChar(content.getContentName())).append(
//					"</Title>\n");
//
//			long category = 0;
//			if (content.getGroup_id() != null) {
//				category = content.getGroup_id();
//			}
//
//			sb.append("<Category>").append(category).append("</Category>\n");
//			
//			sb.append("	<CifsFileContents>\n");
//			
//			
//			List<ContentFile> contentFileList;
//			
//			try 
//			{
//				c
//				
//				for(int i=0; i < contentFileList.size(); i++)
//				{
//					ContentFile c
//					
//					if(contentFile != null 
//							&& !contentFile.getFile_name().equalsIgnoreCase("CifsMetadata.CIFS"))
//					{
//						sb.append("		<FileItem>\n");			
//						sb.append("			<FileId>").append(contentFile.getFile_id()).append("</FileId>\n");
//						sb.append("			<FileName>").append(contentFile.getFile_name()).append("</FileName>\n");			
//						sb.append("			<FileSize>").append(contentFile.getFile_size()).append("</FileSize>\n");
//						sb.append("			<FileHashValue>").append(contentFile.getHash_code()).append("</FileHashValue>\n");						
//						sb.append("		</FileItem>\n");
//					}
//				}						
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//
//			sb.append("	</CifsFileContents>\n");			
//			
//			sb.append("</CIFSContent>");
//
//			FileOutputStream outputStream = new FileOutputStream(csdFile);
//			FileChannel fileChannel = outputStream.getChannel();
//			Charset cs = Charset.forName("UTF-8");
//			CharsetEncoder encoder = cs.newEncoder();
//			fileChannel.write(encoder.encode(CharBuffer.wrap(sb.toString())));
//
//			return csdFile;
//		} 
//		catch (IOException e) 
//		{
//			logger.info(e.getMessage());
//		}
//		return null;
//	}
//
//	
//	// COPY File	
//	public synchronized void copyFile(File srcFile, File destFile) 
//	{
//		FileInputStream fis = null;
//		FileOutputStream fos = null;
//		int data = 0;
//		
//		try {
//			fis = new FileInputStream(srcFile);
//			fos = new FileOutputStream(destFile);
//			
//			while( (data = fis.read()) !=-1 )
//				fos.write(data);
//			
//			if( fis!= null ) fis.close();
//			if( fos!= null ) fos.close();
//			System.out.println("[File_Thread] copy file success !!!");
//			
//		} catch(Exception e) {
//			System.out.println("[File_Thread] copy file fail !!!");
//		}
//	}	
//	
//	
//	
//	// COPY
//	public synchronized void copyDirectory(File sourcelocation , File targetdirectory)throws IOException, InterruptedException 
//    { 
////		this.wait();
//		
//		if(!targetdirectory.exists())
//		{
//			targetdirectory.mkdir();
//			
//			FileOutputStream tempTrargetFos = new FileOutputStream(targetdirectory);
//			tempTrargetFos.close();
//		}		 
//		 
//		FileOutputStream fos = null;
//		FileInputStream fis = null;
//		byte b[] = new byte[2048];
//		
//		try 
//		{
//			fis = new FileInputStream(sourcelocation);
//			fos = new FileOutputStream(targetdirectory);
//			
//			int num = 0;
//			
//			while(true)
//			{
//				num = fis.read(b);
//				if(num==-1) 
//					break;
//				fos.write(b);
//				fos.flush();
//			}
//			System.out.println("[CIFS_Thread] Copied Sucessfully!");
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			try 
//			{
////				this.notify();
//				
//				if(fos!=null)fos.close();
//				if(fis!=null)fis.close();
//			} 
//			catch(IOException e) 
//			{
//				e.printStackTrace();
//			}
//		}	 
//    } 
//
//	 
//	// HASHING
//	public String getHash(final File file) 
//	{
//		String retVal = "";		
//		
//		try 
//		{
//			final StringBuffer hash = new StringBuffer("");
//			int index = 0, nread;
//			ByteBuffer buf = ByteBuffer.allocate(20971520);
//			byte[] digest;
//			FileInputStream fileIS;
//	
//			fileIS = new FileInputStream(file);
//	
//			FileChannel fileChannel = fileIS.getChannel();
//			MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
//			
//			long fileOffsetLong = 0l;
//			
//			while ((nread = fileChannel.read(buf, fileOffsetLong)) != -1) {
//				buf.flip();
//				messageDigest.update(buf);
//				buf.clear();
//				fileOffsetLong += nread;
//			}
//			
//			digest = messageDigest.digest();
//	
//			StringBuffer tmpSB = new StringBuffer();
//			for (byte b : digest) {
//				StringBuffer str = new StringBuffer(Integer
//						.toHexString(b & 0xff));
//				if (str.length() == 1) {
//					str = new StringBuffer("0").append(str);
//				}
//				if (index > 7 && index < 16)
//					tmpSB = tmpSB.append(str);
//				else
//					tmpSB = str.append(tmpSB);
//				if (index == 3 || index == 5 || index == 7 || index == 9
//						|| index == 15) {
//					hash.append(tmpSB).append("-");
//					tmpSB = new StringBuffer();
//				}
//				index++;
//			}
//			hash.append(tmpSB);
//			
//			if (hash.equals("")) {
//				retVal = null;
//			} else {
//				retVal = hash.toString().toUpperCase();
//			}
//		} 
//		catch (IOException e) 
//		{
//			e.printStackTrace();
//			System.out.println("Failed to hash!");
//		} 
//		catch (NoSuchAlgorithmException e) 
//		{
//			e.printStackTrace();
//			System.out.println("Failed to hash!");
//		}
//		
////		System.out.println("[File_Thread] hash : " + retVal);
//		return retVal;
//	}	
//		
//	
//	// ASK
//	public boolean deleteDirectoryRecursive(File filePath)
//	{
//	    if(filePath.exists()) 
//	    {
//	        File[] files = filePath.listFiles();
//	        
//	        for(int i=0; i<files.length; i++) 
//	        {
//	           if(files[i].isDirectory()) 
//	           {
//	        	   deleteDirectoryRecursive(files[i]); 
//	           }
//	           else 
//	           {
//	        	   files[i].delete();
//	           }
//	        }
//	    }
//	    return (filePath.delete());
//	}	
//}

