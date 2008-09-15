Function ReplaceString(Find, Replacewith, FileName)

  WScript.Echo "replace doc by pdf in : " + FileName

  Dim FileContents, dFileContents

  'Read source text file
  FileContents = GetFile(FileName)

  'replace all string In the source file
  dFileContents = replace(FileContents, Find, ReplaceWith, 1, -1, 0)

  'Compare source And result
  'If (dFileContents <> FileContents) Then
    'write result If different
  WriteFile FileName, dFileContents
  'End if

  Wscript.Echo "Replace done."

End Function

' get binary file
Function GetFile(FileName)
  If (FileName<>"") Then
    Dim FS, FileStream
    Set FS = CreateObject("ADODB.Stream")

    on error resume Next
    
    FS.Type = 1
    FS.Open
    FS.LoadFromFile FileName
    GetFile = FS.Read 

    FS.close
    Set FS = Nothing

  End If
End Function


'Read text file
'Function GetFile(FileName)
'  If (FileName<>"") Then
'    Dim FS, FileStream
'    Set FS = CreateObject("Scripting.FileSystemObject")
'      on error resume Next
'      Set FileStream = FS.OpenTextFile(FileName)
'      GetFile = FileStream.ReadAll
'  End If
'End Function

'Write string As a binary file.
Function WriteFile(FileName, Contents)
  Dim FS

  Set FS = CreateObject("ADODB.Stream")

  FS.Type = 1
  FS.Open
  With CreateObject("ADODB.Stream")
    .Type = 2
    .Open: .WriteText Contents
    .Position = 2
    .CopyTo FS, Len(Contents) * 2
    .Close
  End With 

  'FS.Write Contents

  FS.SaveToFile FileName, 2
  FS.Close
  Set FS = Nothing

End Function

'Write string As a text file.
'Function WriteFile(FileName, Contents)
'  Dim OutStream, FS

'  on error resume Next
'  Set FS = CreateObject("Scripting.FileSystemObject")
'    Set OutStream = FS.OpenTextFile(FileName, 2, True)
'    OutStream.Write Contents
'End Function

'Framework
Call ReplaceString("\0046\0100\0111\0099", "\0046\0112\0100\0102", "test2.pdf")