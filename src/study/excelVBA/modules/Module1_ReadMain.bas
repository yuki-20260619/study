Attribute VB_Name = "Module1_ReadMain"
Option Explicit
Private Enum sales
'Public Enum sales
    startCol = 0
    “`•[”Ô† = startCol
    “ú•t = 1
    ŠÔ
    ƒe[ƒuƒ‹”Ô†
    —ˆ‹q”
    ¤•i–¼
    ƒJƒeƒSƒŠ
    ”—Ê
    ’P‰¿
    ”„ã‹àŠz
    x•¥•û–@
    endCol = x•¥•û–@
End Enum
Public Sub ReadMain()
    '// •Ï”‚ğéŒ¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim cls01 As Cls1_setting
    Dim cls02 As Cls2_csv
    Dim cls03 As Cls3_fso
    Dim cls04 As Cls4_Log
    Set cls01 = New Cls1_setting
    Set cls02 = New Cls2_csv
    Set cls03 = New Cls3_fso
    Set cls04 = New Cls4_Log
    
    Dim errorLog() As Variant '// ƒGƒ‰[ƒƒO
    Dim errorRows As Long: errorRows = 0 '// ƒGƒ‰[Œ”
    Dim processLog() As Variant '// ˆ—ƒƒO
    Dim totalRecord As Long '// ‘ƒŒƒR[ƒh”
    Dim readRows As Long: readRows = 0 '// “ÇŒ”
    
    Dim readCsv() As Variant '// “Çcsv
    Dim addData As Variant '// ’Ç‰Áƒf[ƒ^
    
    Dim dicFormalData As Dictionary
    Set dicFormalData = CreateObject("ScriptDictionary")
    Dim dicExistData As Dictionary
    Set dicExistData = CreateObject("Scripting.Dictionary")
    Dim dicAddData As Dictionary
    Set dicAddData = CreateObject("Scripting.Dictionary")
    
    Dim fatalCheck As Boolean: fatalCheck = False
    
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// İ’è
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim startTime As Double
    startTime = cls01.StartTimer '// ƒXƒ^[ƒgƒ^ƒCƒ}[
    
    Call cls01.Setting(False) '// ‰æ–ÊXV E ©“®ŒvZ E ƒCƒxƒ“ƒg‚ğ–³Œø
    '// ƒuƒbƒN‚Ì•ÛŒì‚ğ‰ğœ
    '// ƒV[ƒg‚Ì•ÛŒì‚ğ‰ğœ
    
    '// ³‹K‚Ìƒf[ƒ^‚ğ’è‹`
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call DefineFormalData
    
    ' // ƒƒOì¬
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call CreateErrorCol(errorLog) '// ƒGƒ‰[ƒƒOFƒJƒ‰ƒ€ì¬
    Call CreateProcessCol(processLog) '// ˆ—ƒƒOFƒJƒ‰ƒ€ì¬
    
    '// ƒtƒHƒ‹ƒ_î•ñ‚ğæ“¾‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim openFolderPath As String
    Dim filePaths As Variant '// ‘I‘ğ‚µ‚½ƒtƒ@ƒCƒ‹

    Call RunGetFolderPath(openFolderPath, filePaths)
    
    If fatalCheck = True Then GoTo fatalError
    
     '// ƒtƒ@ƒCƒ‹‚ğ“Ç‚İ‚Ş
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call RunReadCsvFile(cls02, filePaths, readCsv, readYear, dicFormalData)

ProcessComplete:
    '// ˆ—ƒŒƒ|[ƒgEƒGƒ‰[ƒŒƒ|[ƒg‚ğo—Í‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP

    '// ƒV[ƒg‚ğ•À‚Ñ‘Ö‚¦‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    
    '// ƒuƒbƒN‚ÆƒV[ƒg‚Ì•ÛŒì‚ğ—LŒø‚É‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    
    '// İ’è
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call cls01.Setting(True) '// ‰æ–ÊXV E ©“®ŒvZ E ƒCƒxƒ“ƒg‚ğ—LŒø
    '// ƒuƒbƒN‚Ì•ÛŒì‚ğİ’è
    '// ƒV[ƒg‚Ì•ÛŒì‚ğİ’è
    
    '// Œãn––
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Set cls01 = Nothing
    Set cls02 = Nothing
    Set cls03 = Nothing
    Set cls04 = Nothing
    Set dicFormalData = Nothing
    Erase errorLog '// ƒGƒ‰[ƒƒO
    Erase processLog '// ˆ—ƒƒO
    Erase readCsv '// “Çcsv
    Erase addData '// ’Ç‰Áƒf[ƒ^
    
    '// I—¹
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub
fatalError:
    GoTo ProcessComplete
ErrorHandler:
    '// ƒGƒ‰[ƒƒO‚ğæ“¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    
    '// ƒGƒ‰[ƒƒO‚ğ‹L˜^
    'PPPPPPPPPPPPPPPPPPPPPPPPP

    '// ƒtƒ‰ƒO‚ğ•ÏX
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    fatalCheck = True
    GoTo fatalError
End Sub
'// ------------------------------------------------------------------
'  ³‹K‚Ìƒf[ƒ^‚ğ’è‹`
'// ------------------------------------------------------------------
Public Sub GetFormalData(ByRef dicFormalData As Dictionary)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// ³‹K‚Ìƒf[ƒ^‚ğ’è‹`
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    With dicFormalData
        .Add sales.“`•[”Ô†, Array("“`•[”Ô†", sales.“`•[”Ô†, vbString, "•K{")
        .Add sales.“ú•t, Array("“ú•t", sales.“ú•t, vbDate, "•K{")
        .Add sales.ŠÔ, Array("ŠÔ", sales.ŠÔ, vbDate, "•K{")
        .Add sales.ƒe[ƒuƒ‹”Ô†, Array("ƒe[ƒuƒ‹”Ô†", sales.ƒe[ƒuƒ‹”Ô†, vbInteger, "•K{")
        .Add sales.—ˆ‹q”, Array("—ˆ‹q”", sales.—ˆ‹q”, vbInteger, "•K{")
        .Add sales.¤•i–¼, Array("¤•i–¼", sales.¤•i–¼, vbString, "•K{")
        .Add sales.ƒJƒeƒSƒŠ, Array("ƒJƒeƒSƒŠ", sales.ƒJƒeƒSƒŠ, vbString, "•K{")
        .Add sales.”—Ê, Array("”—Ê", sales.”—Ê, vbInteger, "•K{")
        .Add sales.’P‰¿, Array("’P‰¿", sales.’P‰¿, vbCurrency, "•K{")
        .Add sales.”„ã‹àŠz, Array("”„ã‹àŠz", sales.”„ã‹àŠz, vbCurrency, "•K{")
        .Add sales.x•¥•û–@, Array("x•¥•û–@", sales.x•¥•û–@, vbString, "•K{")
    End With
    
    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub



'// ------------------------------------------------------------------
'  ƒtƒHƒ‹ƒ_î•ñ‚ğæ“¾‚·‚é
'// ------------------------------------------------------------------
Public Sub RunGetFolderPath(ByVal openFolderPath As String, byreffilePaths As Variant)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// ƒtƒHƒ‹ƒ_î•ñ‚ğæ“¾‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call GetFolderPath(openFolderPath)
    
    '// ƒtƒHƒ‹ƒ_‚Ì‘¶İƒ`ƒFƒbƒN
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    If IsFolderExist(openFolderPath) = False Then
        '// F001
        fatalCheck = True '// ƒtƒ‰ƒO‚ğ•ÏX
    End If
    
    If cls03.IsFilePath(filePaths, openFolderPath) = False Then '// ƒtƒ@ƒCƒ‹‚ğ‘I‘ğ‚·‚é
        ' // F002
        fatalCheck = True '// ƒtƒ‰ƒO‚ğ•ÏX
    End If

    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
Public Sub GetFolderPath(ByRef openFolderPath As String)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// ƒtƒHƒ‹ƒ_î•ñ‚ğæ“¾‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Const InputCell As String = "B1" '// ƒtƒHƒ‹ƒ_ƒpƒX‚ª“ü—Í‚³‚ê‚½ƒZƒ‹
    
    If SH_Setting.Range(InputCell) = "" Then
        Dim wsh As Object
        Set wsh = CreateObject("WScript.Shell")
        
        '// w’èƒtƒHƒ‹ƒ_‚ª–³‚¢ê‡‚Íƒ}ƒCƒhƒLƒ…ƒƒ“ƒg‚ğw’è
        openFolderPath = wsh.SpecialFolders("MyDocuments")
        
        '// Œãn––
        Set wsh = Nothing
    Else
        '// w’èƒtƒHƒ‹ƒ_‚ğæ“¾
        openFolderPath = SH_Setting.Range(InputCell)
    End If
       
    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
Public Function IsFolderExist(ByVal openFolderPath As String) As Boolean
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// ‹¤’ÊƒƒO‚ğæ“¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call GetCommonLog(cls04, openFolderPath)
    
    '// ƒtƒHƒ‹ƒ_‚Ì‘¶İ‚ğŠm”F‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim filePaths As Variant
    IsFolderExist = True
    
    If Dir(openFolderPath, vbDirectory) = "" Then
        IsFolderExist = False '// w’èƒtƒHƒ‹ƒ_‚ª‘¶İ‚µ‚È‚¢ê‡
    End If
    
    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Function
    
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Function




'// ------------------------------------------------------------------
'  csvƒtƒ@ƒCƒ‹‚ğ“Ç‚İ‚Ş
'// ------------------------------------------------------------------
Public Sub RunReadCsvFile(ByRef cls02 As Cls2_csv, ByRef filePaths As Variant, ByRef readCsv As Variant, ByRef readYear As Variant, ByRef dicFormalData As Dictionary)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// csvƒtƒ@ƒCƒ‹‚ğ“Ç‚İ‚Ş
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim filePath As Variant
    
    For Each filePath In filePaths
        Call ReadOneCsv(cls02, filePath, readCsv)
    Next

ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
Public Sub ReadOneCsv(ByRef cls02 As Cls2_csv, ByRef filePath As Variant, ByRef readCsv As Variant, _
                                  ByRef dicFormalData As Dictionary, ByRef dicExistData As Dictionary)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// •Ï”éŒ¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Const charCode As String = "UTF-8" '// ˆµ‚¤•¶šƒR[ƒh
    
    With cls02
        '// •¶šƒR[ƒh‚ªˆê’v‚µ‚Ä‚¢‚é‚©”»’f‚·‚é
        'PPPPPPPPPPPPPPPPPPPPPPPPP
        If .IsCharCode(filePaths(fileCount), charCode) = False Then
            '// E001 '// •¶šƒR[ƒh‚ªˆê’v‚µ‚È‚©‚Á‚½ê‡
            Exit Sub
        End If
        
        '// csv‚ğ“Ç‚İ‚Ş
        'PPPPPPPPPPPPPPPPPPPPPPPPP
        Call .CsvReading(filePath, charCode, readCsv)
    End With
    
    '// ƒwƒbƒ_[Šm”F
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    If IsExpectedColumnsName(dicFormalData, readCsv) = False Then
        '// E002
        Exit Sub
    End If
    
    '// ğŒ‚ğ–‚½‚µ‚½ƒf[ƒ^‚ğæ‚è‚Ş
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call GetImportData(readCsv, readYear, dicExistData)
    
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
'// ------------------------------------------------------------------
'  ƒwƒbƒ_[Šm”F
'// ------------------------------------------------------------------
Public Function IsExpectedColumnsName(ByRef dicFormalData As Dictionary, ByRef readCsv As Variant) As Boolean
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// ƒJƒ‰ƒ€–¼‚ªˆê’v‚µ‚Ä‚¢‚é‚©”»’f‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    IsExpectedColumnsName = True
    Dim i As Long
    Dim getInfo As Variant
    
    For i = LBound(readCsv, 1) To UBound(readCsv, 1) Step 1
        Erase getInfo
        getInfo = dicFormalData(i)
        
        If readCsv(i, LBound(readCsv, 2)) = getInfo(0) Then
            IsExpectedColumnsName = False
        End If
    Next i

    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Function
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
    
End Function
'// ------------------------------------------------------------------
'  ƒtƒ@ƒCƒ‹‚ğ‚P‚Â‚¸‚Âæ“¾‚·‚é
'// ------------------------------------------------------------------
Public Sub GetImportData(ByRef readCsv As Variant, ByRef readYear As Variant, dicExistData As Dictionary)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// •Ï”‚ğéŒ¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim targetYear As Variant
    
    '// æˆø”N‚ğæ“¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call GetBusinessYears(readCsv, readYear, dicExistData)
    
    For Each targetYear In readYear
        '// Šù‘¶ƒf[ƒ^‚ÌƒV[ƒg‚ª‘¶İ‚·‚é‚©”»’f
        'PPPPPPPPPPPPPPPPPPPPPPPPP
        If IsWorksheetExist(targetYear) = False Then
            Call WsAddTargetYear(targetYear) '//ƒV[ƒg‚ğì¬‚·‚é
        End If
        
        '// Šù‘¶ƒf[ƒ^‚ğæ“¾‚·‚é
        'PPPPPPPPPPPPPPPPPPPPPPPPP
        Call GetTargetYearExistData(dicExistData, targetYear)
        
        '// ğŒ‚ğ–‚½‚·ƒf[ƒ^‚ğæ“¾‚·‚é
        'PPPPPPPPPPPPPPPPPPPPPPPPP
        If IsConditionsData(dicExistData, dicAddData, _
                                    readCsv, getYear, addData) = False Then
            '// ƒGƒ‰[ƒŒƒR[ƒhXV
        Else
            '// “ÇƒŒƒR[ƒhXV
        End If
    Next
    '// Œãn––
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    
    
    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub
    
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub



'// ------------------------------------------------------------------
'  ƒtƒ@ƒCƒ‹“à‚Ìæˆø”N‚ğæ“¾‚·‚é
'// ------------------------------------------------------------------
Public Sub GetBusinessYears(ByRef readCsv As Variant, ByRef readYear As Variant, ByRef addData As Variant, _
                                        ByRef dicExistData As Dictionary, ByRef dicAddData As Dictionary)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// •Ï”éŒ¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim getYear As String
    Dim yearCount As Long: yearCount = 0
    Dim dicYear As Dictionary
    Set dicYear = CreateObject("Scripting.Dictionary")
    Dim i As Long
    Erase readYear
    
    '// readCsv“à‚Ìæˆø”N‚ğ‚·‚×‚Äæ“¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    For i = LBound(readCsv, 2) To UBound(readCsv, 2) Step 1
        getYear = Year(readCsv(sales.“ú•t, i))
        
        If dicYear.Exists(getYear) = False Then
            ReDim Preserve readYear(yearCount)
            
            '// æˆø”N‚ğæ“¾
            'PPPPPPPPPPPPPPPPPPPPPPPPP
            dicYear.Add getYear
            readYear(yearCount) = getYear '// æˆø”N‚ğ”z—ñ‚ÉŠi”[
            
            yearCount = yearCount + 1
        End If
    Next i

    '// Œãn––
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Set dicYear = Nothing
    
    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub
    
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
'// ------------------------------------------------------------------
'  ‘ÎÛ‚ÌƒV[ƒg‚ª‘¶İ‚·‚é‚©”»’f‚·‚é
'// ------------------------------------------------------------------
Public Function IsWorksheetExist(ByRef targetYear As String) As Boolean
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler

    '// ‘ÎÛ”N‚ÌƒV[ƒg‚ª‘¶İ‚·‚é‚©Šm”F
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    IsWorksheetExist = False
        
    For Each ws In ThisWorkbook.Worksheets
        If ws.Name = targetYear Then
            IsWorksheetExist = True '// ƒV[ƒg‚ª‘¶İ‚µ‚½‚çƒtƒ‰ƒO‚ğ•ÏX
        End If
    Next ws

    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Function
    
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Function
'// ------------------------------------------------------------------
'  ‘ÎÛ‚ÌƒV[ƒg‚ğì¬‚·‚é
'// ------------------------------------------------------------------
Public Sub WsAddTargetYear(ByVal targetYear As String)

    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// ‘ÎÛ”N‚ÌƒV[ƒg‚ğì¬‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim ws As Worksheet
    Set ws = Worksheets.Add

    With ws
        .Name = targetYear
        .Cells(1, sales.“`•[”Ô†) = "“`•[”Ô†"
        .Cells(1, sales.“ú•t) = "“ú•t"
        .Cells(1, sales.ŠÔ) = "ŠÔ"
        .Cells(1, sales.ƒe[ƒuƒ‹”Ô†) = "ƒe[ƒuƒ‹”Ô†"
        .Cells(1, sales.—ˆ‹q”) = "—ˆ‹q”"
        .Cells(1, sales.¤•i–¼) = "¤•i–¼"
        .Cells(1, sales.ƒJƒeƒSƒŠ) = "ƒJƒeƒSƒŠ"
        .Cells(1, sales.”—Ê) = "”—Ê"
        .Cells(1, sales.’P‰¿) = "’P‰¿"
        .Cells(1, sales.”„ã‹àŠz) = "”„ã‹àŠz"
        .Cells(1, sales.x•¥•û–@) = "x•¥•û–@"
    End With
    
    '// Œãn––
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Set ws = Nothing
    
    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
'// ------------------------------------------------------------------
'  æˆø”N‚ÌŠù‘¶ƒf[ƒ^‚ğæ“¾‚·‚é
'// ------------------------------------------------------------------
Public Sub GetTargetYearExistData(ByRef dicExistData As Dictionary, ByVal targetYear As String)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// •Ï”‚ğéŒ¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim existData As Variant '// ƒV[ƒgî•ñ‚ğ”z—ñ‚ÉŠi”[
    existData = ThisWorkbook.Worksheets(targetYear).UsedRange
    Dim i As Long
    Dim j As Long
            
    Dim items(lastCol) As Variant
    Dim key As String
    
    '// ‰ß‹ƒf[ƒ^ƒV[ƒg“à‚Ìî•ñ‚ğdictionary‚ÉŠi”[‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    For i = LBound(existData, 1) To UBound(existData, 1) Step 1  '// ÅIs‚Ü‚Åƒ‹[ƒv
        For j = LBound(existData, 2) To UBound(existData, 2) Step 1  '// ÅI—ñ‚Ü‚Åƒ‹[ƒv
            items(j) = .Cells(i, j).value
        Next j
        
        key = Join(items, ",")
        
        '// Šù‘¶æˆø‚ğdictionary‚É’Ç‰Á
        If dicExistData.Exists(key) = False Then
            dicExistData.Add key
        End If
    Next i

    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub

ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
'// ------------------------------------------------------------------
'  ğŒ‚ğ–‚½‚·sƒf[ƒ^‚ğæ“¾‚·‚é
'// ------------------------------------------------------------------
Public Function IsConditionsData(ByRef dicExistData As Dictionary, ByRef dicAddData As Dictionary, _
                                        ByRef readCsv As Variant, ByVal getYear As String, ByRef addData As Variant) As Boolean
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler

    '// •Ï”‚ğéŒ¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim rowCount As Long
    Dim colCount As Long
    Dim getInfo As Variant
    getInfo = dicFormalData(colCount)
    Dim items As Variant
    IsConditionsData = True
    
    For rowCount = LBound(readCsv, 2) To UBound(readCsv, 2) Step 1
        For colCount = LBound(readCsv, 1) To UBound(readCsv, 1) Step 1
            '// ”z—ñ‚ğÄ’è‹`
            'PPPPPPPPPPPPPPPPPPPPPPPPP
            items(i) = readCsv(colCount, rowCount)
            
            '// Œ^‚ªˆê’v‚µ‚Ä‚¢‚é‚©”»’f‚·‚é
            'PPPPPPPPPPPPPPPPPPPPPPPPP
            If IsExpectedType(readCsv(colCount, rowCount), getInfo(2)) = False Then
                '// E004
                IsConditionsData = False
                Exit For
            End If
            
            '// Šù‘¶ƒf[ƒ^‚Æ‚Ìd•¡‚ğ”»’f‚·‚é
            'PPPPPPPPPPPPPPPPPPPPPPPPP
            If CanObtainData(dicExistData, dicAddData, readCsv, items) = False Then
                '// E005
                
                IsConditionsData = False
                Exit For
            Else
                '// ’Ç‰Áƒf[ƒ^‚ğdictionary‚É’Ç‰Á
            End If
        Next colCount
    Next rowCount
    
    '// Œãn––
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Erase getInfo
    Erase items

    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Function

ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Function
'// ------------------------------------------------------------------
'  ƒf[ƒ^‚ÌŒ^‚ªˆê’v‚µ‚Ä‚¢‚é‚©”»’f
'// ------------------------------------------------------------------
Private Function IsExpectedType(ByVal value As Variant, ByVal expectedType As VbVarType) As Boolean
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    IsExpectedType = (VarType(value) = expectedType)

    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Function

ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Function
'// ------------------------------------------------------------------
'  Šù‘¶ƒf[ƒ^‚Æd•¡‚µ‚Ä‚¢‚È‚¢æˆøƒf[ƒ^‚ğæ“¾‚·‚é
'// ------------------------------------------------------------------
Public Function CanObtainData(ByRef dicExistData As Dictionary, ByRef dicAddData As Dictionary, ByRef readCsv As Variant, ByRef items As Variant) As Boolean
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// ‘ÎÛ‚Ìƒf[ƒ^‚ªæ‚è‚İŠî€‚ğ–‚½‚µ‚Ä‚¢‚é‚©”»’f
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    CanObtainData = True
    Dim key As String
    Dim getInfo As Variant '// ƒJƒ‰ƒ€–¼ / —ñ”Ô† / Œ^ / •K{
    Dim i As Long
    Dim j As Long
    Dim readRows As Long: readRows = 0
    Dim errorRows As Long: errorRows = 0
    Dim ErrorRow As Long
    Dim errorFlag As Boolean: errorFlag = False
        
    key = Join(items, ",")
        
    '// Šù‘¶æˆø‚É‘¶İ‚µ‚È‚¢ê‡Adictionary‚É’Ç‰Á
    If dicExistData.Exists(key) = False Then
        dicAddData.Add key               '// dictionary‚É’Ç‰Á
    End If
    
    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Function
    
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Function



