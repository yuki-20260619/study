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
    Dim cls01 As Cls1_setting
    Dim cls02 As Cls2_csv
    Dim cls03 As Cls3_fso
    Dim cls04 As Cls4_Log
    Set cls01 = New Cls1_setting
    Set cls02 = New Cls2_csv
    Set cls03 = New Cls3_fso
    Set cls04 = New Cls4_Log
    Dim errorLog() As Variant '// ƒGƒ‰[ƒƒO
    Dim processLog() As Variant '// ˆ—ƒƒO
    Dim readCsv() As Variant '// “Çcsv
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
    Dim dicFormalData As Dictionary
    Set dicFormalData = CreateObject("ScriptDictionary")
    
    Call DefineFormalData
    
    ' // ƒƒOì¬
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call CreateErrorCol(errorLog) '// ƒGƒ‰[ƒƒOFƒJƒ‰ƒ€ì¬
    Call CreateProcessCol(processLog) '// ˆ—ƒƒOFƒJƒ‰ƒ€ì¬
    
    '// ƒtƒ@ƒCƒ‹î•ñ‚ğæ“¾‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim openFolderpath As String
    Dim filePaths As Variant '// ‘I‘ğ‚µ‚½ƒtƒ@ƒCƒ‹
    
    Call GetFolderPath(openFolderpath) '// ƒtƒHƒ‹ƒ_î•ñ‚ğæ“¾‚·‚é
    If IsFolderExist(openFolderpath) = False Then '// ƒtƒHƒ‹ƒ_‚Ì‘¶İƒ`ƒFƒbƒN
        '// F001
        fatalCheck = True '// ƒtƒ‰ƒO‚ğ•ÏX
    End If
    
    If cls03.IsFilePath(filePaths, openFolderpath) = False Then '// ƒtƒ@ƒCƒ‹‚ğ‘I‘ğ‚·‚é
        ' // F002
        fatalCheck = True '// ƒtƒ‰ƒO‚ğ•ÏX
    End If
    
     '// ƒtƒ@ƒCƒ‹‚ğ“Ç‚İ‚Ş
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim i As Long
    Dim j As Long
    Const charCode As String = "UTF-8" '// ˆµ‚¤•¶šƒR[ƒh
    Dim filePath As String
    Dim totalRecord As Long '// ‘ƒŒƒR[ƒh”
    Dim readYear As Variant
    Dim targetYear As String
    Dim existData As Variant '// Šù‘¶ƒf[ƒ^
    Dim AddData() As Variant '// ’Ç‰Áƒf[ƒ^
    
    For i = LBound(filePaths) To UBound(filePaths) Step 1
        Erase myArray '// ”z—ñ‚ğ‰Šú‰»
        filePath = filePaths(i)
        
        With cls02
            If .IsCharCode(filePaths(i), charCode) = fale Then   '// •¶šƒR[ƒh‚ğ”»’f‚·‚é
                '// E001 '// •¶šƒR[ƒh‚ªˆê’v‚µ‚È‚©‚Á‚½ê‡
            Else
                Call .CsvReading(filePath, charCode, readCsv) '// csv‚ğ”z—ñ‚ÉŠi”[‚·‚é
                totalRecord = UBound(myArray, 2) + 1 '// ‘ƒŒƒR[ƒh”‚ğæ“¾
                Call GetTransactionYear(filePath, readYear, readCsv) '// csvƒtƒ@ƒCƒ‹“à‚Ìæˆø”N‚ğæ“¾
                
                For j = LBound(readYear) To UBound(readYear) Step 1
                    targetYear = readYear(j)
                    
                    If IsWorksheetExist(targetYear) = False Then '// ‘ÎÛ‚ÌƒV[ƒg‚ª‘¶İ‚·‚é‚©
                        Call WsAddTargetYear(targetYear) '// ‘ÎÛ”N‚ÌƒV[ƒg‚ğì¬‚·‚é
                    End If
                    
                    '// æˆø”N‚ÌŠù‘¶ƒf[ƒ^‚ğæ“¾‚·‚é
                Next j
            End If
        End With
    Next i
    
    If fatalCheck = True Then GoTo fatalError
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
    Erase myArray '// “Çcsv
    Erase AddData '// ’Ç‰Áƒf[ƒ^
    
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
Public Sub DefineFormalData(ByRef dicFormalData As Dictionary)
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
Public Sub GetFolderPath(ByRef openFolderpath As String)
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
        openFolderpath = wsh.SpecialFolders("MyDocuments")
        
        '// Œãn––
        Set wsh = Nothing
    Else
        '// w’èƒtƒHƒ‹ƒ_‚ğæ“¾
        openFolderpath = SH_Setting.Range(InputCell)
    End If
       
    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
'// ------------------------------------------------------------------
'  ƒtƒHƒ‹ƒ_‚Ì‘¶İƒ`ƒFƒbƒN
'// ------------------------------------------------------------------
Public Function IsFolderExist(ByVal openFolderpath As String) As Boolean
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// ‹¤’ÊƒƒO‚ğæ“¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call GetCommonLog(cls04, openFolderpath)
    
    '// ƒtƒHƒ‹ƒ_‚Ì‘¶İ‚ğŠm”F‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim filePaths As Variant
    IsFolderExist = True
    
    If Dir(openFolderpath, vbDirectory) = "" Then
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
Public Sub ReadCsvFile(ByRef filePaths As Variant)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// ƒtƒ@ƒCƒ‹‚ğ“Ç‚İ‚Ş
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
'// ------------------------------------------------------------------
'  csvƒtƒ@ƒCƒ‹“à‚Ìæˆø”N‚ğæ“¾
'// ------------------------------------------------------------------
Public Sub GetTransactionYear(ByVal filePath As String, ByRef readYear As Variant, ByRef readCsv As Variant)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// myArray“à‚Ìæˆø”N‚ğ‚·‚×‚Äæ“¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim getYear As String
    Dim yearCount As Long: yearCount = 0
    Dim dicYear As Dictionary
    Set dicYear = CreateObject("Scripting.Dictionary")
    Dim i As Long
    
    For i = LBound(readCsv, 2) To UBound(readCsv, 2) Step 1
        getYear = Year(readCsv(sales.“ú•t, i))
        
        If dicYear.Exists(getYear) = False Then
            ReDim Preserve readYear(yearCount)
            
            dicYear.Add getYear '// æˆø”N‚ğ«‘“o˜^
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
    Dim shFlag As Boolean: shFlag = False
    IsWorksheetExist = True
        
    For Each ws In ThisWorkbook.Worksheets
        If ws.Name = targetYear Then
            shFlag = True '// ƒV[ƒg‚ª‘¶İ‚µ‚½‚çƒtƒ‰ƒO‚ğ•ÏX
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
Public Sub GetTargetYearExistData()

End Sub
Public Sub AddDataCopy(ByRef myArray As Variant, ByRef AddData As Variant, ByRef cls04 As Cls4_Log, _
                                    ByRef fatalCheck As Boolean, ByRef errorLog As Variant, ByRef processLog As Variant, ByVal startTime As Double)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// myArray‚Ìæˆø”N‚ğæ“¾‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim readYear() As Variant
    Call GetTransactionYear(myArray, readYear)
    
    '// æ‘ÎÛ‚Ìƒf[ƒ^‚ğæ“¾‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim i As Long
    Dim j As Long
    
    For i = LBound(readYear) To UBound(readYear) Step 1
        '// Šù‘¶ƒf[ƒ^‚ğ”z—ñ‚ÉŠi”[‚·‚é
        'PPPPPPPPPPPPPPPPPPPPPPPPP
        Dim historicalData() As Variant
        Dim transactionYear As String: transactionYear = readYear(i)
        Dim dicExistData As Dictionary
        Set dicExistData = CreateObject("Scripting.Dictionary")
        
        Call GetHistoricalData(historicalData, fatalCheck, transactionYear, dicExistData)
        
        '// myArray“à‚Ìæˆø‘ÎÛ”N‚Ìæˆø‚ªAŠù‘¶ƒf[ƒ^“à‚É‘¶İ‚µ‚È‚¢‚©”»’f‚·‚é
        Call IsExistsData(cls04, errorLog, processLog, myArray, dicExistData, dicFormalData, transactionYear, totalRecord, startTime)
        
    Next i

    
    '//  ƒf[ƒ^Œ^‚É‘Šˆá‚ª‚È‚¢‚©”»’f‚·‚é
    '// “¯ˆêƒf[ƒ^‚ª‘¶İ‚µ‚È‚¢‚©”»’f‚·‚é
EndLabel:
    '// Œãn––
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Set ws = Nothing
    Set dicExistData = Nothing
    Set dicFormalData = Nothing
    Erase readYear
    Erase historicalData
    
    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub

ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
Public Sub PrepareCheck(ByRef cls04 As Cls4_Log, ByRef errorLog As Variant, ByRef processLog As Variant, ByRef myArray As Variant, _
                                    ByRef dicFormalData As Dictionary, ByVal startTime As Double)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// ƒJƒ‰ƒ€–¼‚Ì‘Šˆá‚ª‚È‚¢‚©”»’f‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim i As Long
    Dim checkColName As String
    Dim targetContent As String    '// ƒGƒ‰[‘ÎÛ‚ÌƒJƒ‰ƒ€–¼
    Dim getInfo As Variant           '// ƒJƒ‰ƒ€–¼ / —ñ”Ô† / Œ^ / •K{
    Dim getFormalColName As String
    
    For i = LBound(myArray, 1) To UBound(myArray, 1) Step 1
        checkColName = myArray(i, LBound(myArray, 2))   '// ‘ÎÛƒJƒ‰ƒ€‚Ìƒ`ƒFƒbƒNƒf[ƒ^‚ğæ“¾
        getInfo = dicFormalData(i + 1)                               '// ‘ÎÛƒJƒ‰ƒ€‚Ì³‹Kƒf[ƒ^‚ğæ“¾
        getFormalColName = getInfo(0)
        
        If checkColName <> getFormalColName Then
            targetContent = checkColName
            GoTo E002 '// ƒJƒ‰ƒ€–¼‚ªˆê’v‚µ‚È‚¢ê‡
        End If
    Next i
    
    '// æˆøƒf[ƒ^‚ª‘¶İ‚·‚é‚©”»’f‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    If UBound(myArray, 2) = 0 Then
        GoTo E003 '// æˆøƒf[ƒ^‚ª‘¶İ‚µ‚È‚¢ê‡
    End If
EndLabel:
    '// Œãn––
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    
    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub
E002: '// ƒJƒ‰ƒ€–¼‚ªˆê’v‚µ‚È‚¢ê‡
    '// E002ƒGƒ‰[ƒƒO‚ğæ“¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call GetErrorE002(cls04, startTime, targetContent)
    
    '// ƒGƒ‰[ƒƒO‚ğ‹L˜^
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call WriteErrorLog(errorLog, cls04)
    
    '// ˆ—ƒƒO‚ğ‹L˜^
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call WriteProcessLog(processLog, cls04)
    
    '// ˆ—‚ğI—¹
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    GoTo EndLabel
E003: '// æˆøƒf[ƒ^‚ª‘¶İ‚µ‚È‚¢ê‡
    '// E003ƒGƒ‰[ƒƒO‚ğæ“¾
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call GetErrorE003(cls04, startTime)
    
    '// ƒGƒ‰[ƒƒO‚ğ‹L˜^
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call WriteErrorLog(errorLog, cls04)
    
    '// ˆ—ƒƒO‚ğ‹L˜^
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Call WriteProcessLog(processLog, cls04)
    
    '// ˆ—‚ğI—¹‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    GoTo EndLabel
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
Public Sub GetHistoricalData(ByRef historicalData As Variant, ByRef fatalCheck As Boolean, ByVal transactionYear As String, ByRef dicExistData As Dictionary)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// ‰ß‹ƒf[ƒ^ƒV[ƒg“à‚Ìî•ñ‚ğ”z—ñ‚ÉŠi”[‚·‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim ws As Worksheet
    Set ws = ThisWorkbook.Worksheets(transactionYear)
    Dim lastRow As Long
    Dim lastCol As Long
    Dim i As Long
    Dim j As Long
    Dim k As Long: k = 0
            
    With ws
        lastRow = .Cells(Rows.Count, 1).End(xlUp).Row
        lastCol = .Cells(1, Columns.Count).End(xlToLeft).Column
        ReDim Preserve historicalData(lastCol - 1, lastRow - 1)
        Dim items(lastCol - 1) As Variant
        Dim key As String
        
        For i = 1 To lastRow Step 1 '// ÅIs‚Ü‚Åƒ‹[ƒv
            For j = 1 To lastCol Step 1 '// ÅI—ñ‚Ü‚Åƒ‹[ƒv
                items(j - 1) = .Cells(i, j).value
            Next j
            
                key = Join(items, ",")
                
                '// Šù‘¶æˆø‚ğdictionary‚É’Ç‰Á
                If dicExistData.Exists(key) = False Then
                    dicExistData.Add key
                End If
        Next i
    End With

    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub
    
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
Public Sub IsExistsData(ByRef cls04 As Cls4_Log, ByRef errorLog As Variant, ByRef processLog As Variant, ByRef myArray As Variant, _
                                  ByRef dicExistData As Dictionary, ByRef dicFormalData As Dictionary, ByVal targetYear As Long, ByVal totalRecord As Long, ByVal startTime As Double)
    '// —\Šú‚¹‚ÊƒGƒ‰[ŒŸ’m
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    On Error GoTo ErrorHandler
    
    '// ‹¤’ÊƒƒO‚ğ”z—ñ‚ÉˆêŸ‹L˜^
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim commonLogArray(4) As Variant
    With cls04
        commonLogArray(0) = .RunDateTime   '// Às“ú
        commonLogArray(1) = .UserName       '// ÀsÒ
        commonLogArray(2) = .FolderPath       '// ƒtƒHƒ‹ƒ_ƒpƒX
        commonLogArray(3) = .FileName         '// ƒtƒ@ƒCƒ‹–¼
        commonLogArray(4) = totalRecord      '// ƒŒƒR[ƒh”
    End With
    
    '// ‘ÎÛ‚Ìƒf[ƒ^‚ªŠù‘¶ƒf[ƒ^‚É‘¶İ‚µ‚È‚¢‚©”»’f
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Dim dicAddData As Dictionary
    Set dicAddData = CreateObject("Scripting.Dictionary")
    Dim items() As Variant
    Dim key As String
    Dim getInfo As Variant '// ƒJƒ‰ƒ€–¼ / —ñ”Ô† / Œ^ / •K{
    Dim i As Long
    Dim j As Long
    Dim readRows As Long: readRows = 0
    Dim errorRows As Long: errorRows = 0
    Dim ErrorRow As Long
    Dim errorFlag As Boolean: errorFlag = False
    
    For i = LBound(myArray, 2) + 1 To UBound(myArray, 2) Step 1 '// s‚ğƒ‹[ƒv
        ReDim items(UBound(myArray, 1))
        
        For j = LBound(myArray, 1) To UBound(myArray, 1) Step 1 '// —ñ‚ğƒ‹[ƒv
            '// ³‹Kƒf[ƒ^‚ğ’è‹`
            getInfo = dicFormalData(j + 1)
            
            '// ƒf[ƒ^‚ÌŒ^‚ªˆê’v‚µ‚Ä‚¢‚é‚©”»’f
            If Not IsExpectedType(myArray(j, i), getInfo(2)) Then
                errorRows = errorRows + 1
                ErrorRow = i + 1
                GoTo E004
            Else
                items = myArray(j, i)
            End If
        Next j
        
            key = Join(items, ",")
                
            '// Šù‘¶æˆø‚É‘¶İ‚µ‚È‚¢ê‡Adictionary‚É’Ç‰Á
            If dicExistData.Exists(key) = False Then
                dicAddData.Add key               '// dictionary‚É’Ç‰Á
                readRows = readRows + 1     '// “ÇƒŒƒR[ƒh”‚ğXV
            Else                                    '// Šù‘¶æˆø‚É“¯ˆêƒf[ƒ^‚ª‘¶İ‚·‚éê‡
                errorRows = errorRows + 1    '// ƒGƒ‰[ƒŒƒR[ƒh”‚ğXV
                GoTo E005
            End If
    Next i
    
    '// sub‚ğ”²‚¯‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Exit Sub
E004: '// ƒf[ƒ^‚ÌŒ^‚ªˆê’v‚µ‚È‚¢ê‡

E005: '// “¯ˆêƒf[ƒ^‚ª‚·‚Å‚É“o˜^‚³‚ê‚Ä‚¢‚éê‡
    
ErrorHandler:
    '// ”­¶‚µ‚½ƒGƒ‰[‚ğŒÄ‚Ño‚µŒ³‚É“Š‚°‚é
    'PPPPPPPPPPPPPPPPPPPPPPPPP
    Err.Raise Err.Number, , Err.Description
End Sub
Private Function IsExpectedType(ByVal value As Variant, ByVal expectedType As VbVarType) As Boolean
    IsExpectedType = (VarType(value) = expectedType)
End Function
