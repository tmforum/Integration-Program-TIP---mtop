#!/usr/bin/ruby

# This ruby script walks through the MTOSI directory structure 
# converting all pdf files with .doc to .pdf extensions in their URL links
# it then puts the resulting files into directories for zipping.


# report links
$links = Hash.new();
def reportLinks()
  linkFile = File.open("target/links.csv","w");
  linkFile.puts "\"linkToFile\",\"linkFromFile\"";
  $links.keys().sort().each() { | aKey |
    $links[aKey].keys().sort().each() { | aSubKey |
      linkFile.puts "\"#{aKey}\",\"#{aSubKey}\"";
    }
  }
  linkFile.close();
end

# convert a pdf file
def convertPdf(file, srcDir, destDir)

  # first do the conversion...
  inFileName = "#{srcDir}/#{file}";
  outFileName = "#{destDir}/#{file}";
  puts "converting: [#{inFileName}]";
  puts "\tto: [#{outFileName}]";

  inFile = File.open(inFileName,"r");
  inFileContents = inFile.read();
  inFileContents.gsub!(/\.doc\)/, ".pdf)");
  outFile = File.open(outFileName,"w");
  outFile.write(inFileContents);
  inFile.close();
  outFile.close();

  # no walk through the document looking for links to report
  inFile = File.open(inFileName,"r");
  inFile.each_line() { | aLine |
    if (aLine =~ /\/F\([^\)]*\.doc\)\>\>/) then
      aLine.chomp!();
      aLink = aLine.sub(/^.*\/F\(/,"");
      aLink = aLink.sub(/\.doc\)\>\>/,".doc");
      if (!$links.has_key?(aLink)) then
	$links[aLink] = Hash.new();
      end
      $links[aLink][inFileName] = true;
    end
  }
  inFile.close();

  puts "\t\tdone";
end


# walk through the existing directories looking for pdf files
def findPdfFiles(file, srcDir, destDir) 

  # puts "looking at: #{srcDir}/#{file}";

  srcFile = "#{srcDir}/#{file}";
  destFile = "#{destDir}/#{file}";

  if (File.directory?(srcFile)) then
    system("mkdir #{destFile}");
    Dir.entries(srcFile).sort().each() { | aFile |
      next if (aFile =~ /^\.$/);
      next if (aFile =~ /^\.\.$/);
      next if (aFile =~ /^\.svn$/);
      next if (aFile =~ /^target$/);
      findPdfFiles(aFile, srcFile, destFile);
    }
  else 
    if (srcFile =~ /\.pdf/) then
      convertPdf(file, srcDir, destDir);
    end
  end

end

# create zip files
$ddpName = Hash.new();
$ddpName["Framework"] = "fwk";
$ddpName["NetworkResourceFulfillment"] = "nrf";
$ddpName["ServiceActivation"] = "sa";
$ddpName["ManageResourceInventory"] = "mri";
$ddpName["ResourcePerformanceManagement"] = "rpm";
$ddpName["ServiceBasic"] = "sb";
$ddpName["NetworkResourceAssurance"] = "nra";
$ddpName["ResourceProvisioning"] = "rp";
$ddpName["NetworkResourceBasic"] = "nrb";
$ddpName["ResourceTroubleManagement"] = "rtm";

def createZipFiles()
  system("mkdir target/ProductDescription");

  Dir.chdir("target");

  Dir.entries("DDPs").sort().each() { | aFile |
    next if (aFile =~ /^\.$/);
    next if (aFile =~ /^\.\.$/);
    next if (aFile =~ /^pom.xml$/);
    next if (aFile =~ /^\.svn$/);
    puts "building zipfile for [#{aFile}]";
    releaseNotesFileName = "TMF521_MTOSI_Release2.0BA-#{$ddpName[aFile]}.pdf";
    system("cp ../ProductDescription/TMF521_MTOSI_Release2.0BA.pdf ProductDescription/#{releaseNotesFileName}");

    readmeFileName = "README-#{$ddpName[aFile]}.txt";
    system("cp ../ProductDescription/README.txt #{readmeFileName}");
    system("echo \"------\" >> #{readmeFileName}");
    system("echo \"SubVersion version control information:\" >> #{readmeFileName}");
    system("svn info .. >> #{readmeFileName}");
    system("echo \"------\" >> #{readmeFileName}");
    system("echo \"zipfile archive created on:\" >> #{readmeFileName}");
    system("date >> #{readmeFileName}");
    system("uname -a >> #{readmeFileName}");
    system("echo \"------\" >> #{readmeFileName}");

    system("zip -r mtosi-#{$ddpName[aFile]}-2_0ba #{readmeFileName} DDPs/#{aFile} ProductDescription/#{releaseNotesFileName}");
  }
end

# clean up
system("rm -rf target");

# create target directory
system("mkdir target");

# fix up all pdf files
findPdfFiles("", ".", "target");

# report the links
reportLinks();

# create zip files
createZipFiles();
