package com.vmetry.ntltaxi.reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.vmetry.ntltaxi.initialiser.Initialiser;

public class ReportGenerator extends Initialiser {

	public static void archivefile() throws IOException
	{
		if(isArchive)
		{
				
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd-HH-MM-SS-mmm");
	String date = sdf.format(new Date());
	
		File src = new File("C:\\Seleniumworkspace\\DDDTest\\Screenshot");
		File dst = new File("C:\\Seleniumworkspace\\DDDTest\\ArchiveFile\\old_"+date);
		FileUtils.copyDirectory(src, dst);
		FileUtils.cleanDirectory(src);
		isArchive=false;
		}
	}
}
