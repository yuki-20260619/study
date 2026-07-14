Attribute VB_Name = "CsvRead5__Log"
Option Explicit
Private Enum colProcessLog
'Public Enum colProcessLog
    実行日時 = 0
    実行者
    フォルダパス
    ファイル名
    レコード数
    読込レコード数
    エラーレコード数
    処理ステータス
    処理時間
    endcol = 処理時間
End Enum
Private Enum colErrorLog
'Public Enum colErrorLog
    実行日時 = 0
    実行者
    フォルダパス
    ファイル名
    エラーコード
    エラー行番号
    該当データ
    エラー理由
    endcol = エラー理由
End Enum
'// -------------------------------------------------------
'  処理ログ
'// -------------------------------------------------------
Public Sub CreateProcessCol(ByRef processLog() As Variant)
    ReDim processLog(colProcessLog.endcol, 0)
    
    processLog(colProcessLog.実行日時, 0) = "実行日時"
    processLog(colProcessLog.実行者, 0) = "実行者"
    processLog(colProcessLog.フォルダパス, 0) = "フォルダパス"
    processLog(colProcessLog.ファイル名, 0) = "ファイル名"
    processLog(colProcessLog.レコード数, 0) = "レコード数"
    processLog(colProcessLog.読込レコード数, 0) = "読込レコード数"
    processLog(colProcessLog.エラーレコード数, 0) = "エラーレコード数"
    processLog(colProcessLog.処理ステータス, 0) = "処理ステータス"
    processLog(colProcessLog.処理時間, 0) = "処理時間"
End Sub
Public Sub WriteProcessLog(ByRef processLog As Variant, ByRef cls04 As Cls4_Log)
    Dim writeRow As Long
    writeRow = UBound(processLog, 2) + 1
    ReDim Preserve processLog(colProcessLog.endcol, writeRow)
    
    '// ログを記録する
    '￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
    With cls04
        If Not .RunDateTime = "" Then
            processLog(colProcessLog.実行日時, writeRow) = .RunDateTime
        End If
        If Not .UserName = "" Then
            processLog(colProcessLog.実行者, writeRow) = .UserName
        End If
        If Not .FolderPath = "" Then
            processLog(colProcessLog.フォルダパス, writeRow) = .FolderPath
        End If
        If Not .FileName = "" Then
            processLog(colProcessLog.ファイル名, writeRow) = .FileName
        End If
        If Not .totalRecord = 0 Then
            processLog(colProcessLog.レコード数, writeRow) = .totalRecord
        End If
        If Not .ReadRecord = 0 Then
            processLog(colProcessLog.読込レコード数, writeRow) = .ReadRecord
        End If
        If Not .ErrorRecord = 0 Then
            processLog(colProcessLog.エラーレコード数, writeRow) = .ErrorRecord
        End If
        If Not .ProcessStatus = "" Then
            processLog(colProcessLog.処理ステータス, writeRow) = .ProcessStatus
        End If
        If Not .TimeSpent = 0 Then
            processLog(colProcessLog.処理時間, writeRow) = .TimeSpent
        End If
    End With
End Sub
Public Sub CreateErrorCol(ByRef errorLog() As Variant)
    ReDim errorLog(colErrorLog.endcol, 0)
    
    errorLog(colErrorLog.実行日時, 0) = "実行日時"
    errorLog(colErrorLog.実行者, 0) = "実行者"
    errorLog(colErrorLog.フォルダパス, 0) = "フォルダパス"
    errorLog(colErrorLog.ファイル名, 0) = "ファイル名"
    errorLog(colErrorLog.エラーコード, 0) = "エラーコード"
    errorLog(colErrorLog.エラー行番号, 0) = "エラー行番号"
    errorLog(colErrorLog.該当データ, 0) = "該当データ"
    errorLog(colErrorLog.エラー理由, 0) = "エラー理由"
End Sub
Public Sub WriteErrorLog(ByRef errorLog As Variant, ByRef cls04 As Cls4_Log)
    Dim writeRow As Long
    writeRow = UBound(errorLog, 2) + 1
    ReDim Preserve errorLog(colErrorLog.endcol, writeRow)
    
    '// ログを記録する
    '￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
    With cls04
        If Not .RunDateTime = 0 Then
            errorLog(colErrorLog.実行日時, writeRow) = .RunDateTime
        End If
        If Not .UserName = "" Then
            errorLog(colErrorLog.実行者, writeRow) = .UserName
        End If
        If Not .FolderPath = "" Then
            errorLog(colErrorLog.フォルダパス, writeRow) = .FolderPath
        End If
        If Not .FileName = "" Then
            errorLog(colErrorLog.ファイル名, writeRow) = .FileName
        End If
        If Not .ErrorCode = "" Then
            errorLog(colErrorLog.エラーコード, writeRow) = .ErrorCode
        End If
        If Not .ErrorRow = 0 Then
            errorLog(colErrorLog.エラー行番号, writeRow) = .ErrorRow
        End If
        If Not .RelevantData = "" Then
            errorLog(colErrorLog.該当データ, writeRow) = .RelevantData
        End If
        If Not .ErrorReason = "" Then
            errorLog(colErrorLog.エラー理由, writeRow) = .ErrorReason
        End If
    End With
End Sub
Public Sub ClearLog(ByRef cls04 As Cls4_Log)
    With cls04
        .RunDateTime = 0
        .UserName = ""
        .FolderPath = ""
        .FileName = ""
        .totalRecord = 0
        .ReadRecord = 0
        .ProcessStatus = ""
        .TimeSpent = 0
        .ErrorRecord = 0
        .ErrorCode = ""
        .RelevantData = ""
        .ErrorReason = ""
    End With
End Sub
'// -------------------------------------------------------
'  ログ取得
'// -------------------------------------------------------
Public Sub GetCommonLog(ByRef cls04 As Cls4_Log, ByVal openFolderPath As String)
    '// 共通ログを取得
    '￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
    Call WriteRunDateTime(cls04)                          '// 実行日時
    Call WriteUserName(cls04)                              '// 実行者
    Call WriteFolderPath(cls04, openFolderPath)      '// フォルダパス
End Sub
Public Sub GetCommonLogToFile(ByRef cls04 As Cls4_Log, ByVal openFolderPath As String, ByVal FileName As String)
    '// 共通ログを取得
    '￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
    Call WriteRunDateTime(cls04)                          '// 実行日時
    Call WriteUserName(cls04)                              '// 実行者
    Call WriteFolderPath(cls04, openFolderPath)      '// フォルダパス
    Call WriteFileName(cls04, FileName)                 '// ファイル名
End Sub
Public Sub GetErrorF001(ByRef cls04 As Cls4_Log, ByVal startTime As Double)
    '// F001ログを取得
    '￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
    Dim endTime As Double: endTime = Timer
    
    ' // エラーログ
    Call WriteerrorCode(cls04, "F001")                                              '// エラーコード
    Call WriteErrorReason(cls04, "指定フォルダが存在しません。")         '// エラー理由
    
    '// 処理ログ
    Call WriteProcessStatus(cls04, "失敗")                                         '// 処理ステータス
    Call WriteTimeSpent(cls04, startTime, endTime)                          '// 処理時間
End Sub
Public Sub GetErrorF002(ByRef cls04 As Cls4_Log, ByVal startTime As Double)
    '// F002ログを取得
    '￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
    Dim endTime As Double: endTime = Timer
    
    ' // エラーログ
    Call WriteerrorCode(cls04, "F002")                                                  '// エラーコード
    Call WriteErrorReason(cls04, "ファイルが選択されませんでした。")        '// エラー理由
    
    '// 処理ログ
    Call WriteProcessStatus(cls04, "失敗")                                              '// 処理ステータス
    Call WriteTimeSpent(cls04, startTime, endTime)                               '// 処理時間
End Sub
Public Sub GetErrorE001(ByRef cls04 As Cls4_Log, ByVal startTime As Double, ByVal charCode As String)
    '// E001ログを取得
    '￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
    Dim endTime As Double: endTime = Timer
    
    ' // エラーログ
    Call WriteerrorCode(cls04, "E001")                                                                    '// エラーコード
    Call WriteErrorReason(cls04, "文字コードが" & charCode & "ではありません。")        '// エラー理由
    
    '// 処理ログ
    Call WriteProcessStatus(cls04, "失敗")                                                                '// 処理ステータス
    Call WriteTimeSpent(cls04, startTime, endTime)                                                 '// 処理時間
End Sub
Public Sub GetErrorE002(ByRef cls04 As Cls4_Log, ByVal startTime As Double, ByVal targetContent As String)
    '// E002ログを取得
    '￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
    Dim endTime As Double: endTime = Timer
    
    ' // エラーログ
    Call WriteerrorCode(cls04, "E002")                                       '// エラーコード
    Call WriteErrorReason(cls04, "カラム名が一致しません。")        '// エラー理由
    Call WriteRelevantData(cls04, targetContent)                        '// 該当データ
    
    '// 処理ログ
    Call WriteProcessStatus(cls04, "失敗")                                  '// 処理ステータス
    Call WriteTimeSpent(cls04, startTime, endTime)                   '// 処理時間
End Sub
Public Sub GetErrorE003(ByRef cls04 As Cls4_Log, ByVal startTime As Double)
    '// E001ログを取得
    '￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
    Dim endTime As Double: endTime = Timer
    
    ' // エラーログ
    Call WriteerrorCode(cls04, "E003")                                          '// エラーコード
    Call WriteErrorReason(cls04, "取引データが存在しません。")        '// エラー理由
    
    '// 処理ログ
    Call WriteProcessStatus(cls04, "失敗")                                      '// 処理ステータス
    Call WriteTimeSpent(cls04, startTime, endTime)                       '// 処理時間
End Sub
Public Sub WriteRunDateTime(ByRef cls04 As Cls4_Log)
    cls04.RunDateTime = Format(Now, "yyyy/mm/dd/ hh:mm:ss")
End Sub
Public Sub WriteUserName(ByRef cls04 As Cls4_Log)
    cls04.UserName = Environ("USERNAME")
End Sub
Public Sub WriteFolderPath(ByRef cls04 As Cls4_Log, ByVal FolderPath As String)
    cls04.FolderPath = FolderPath
End Sub
Public Sub WriteFileName(ByRef cls04 As Cls4_Log, ByVal FileName As String)
    cls04.FileName = FileName
End Sub
Public Sub WriteerrorCode(ByRef cls04 As Cls4_Log, ByVal ErrorCode As String)
    cls04.ErrorCode = ErrorCode
End Sub
Public Sub WriteTotalRecord(ByRef cls04 As Cls4_Log, ByVal maxRecord As Long)
    cls04.totalRecord = maxRecord
End Sub
Public Sub WriteReadRecord(ByRef cls04 As Cls4_Log, ByVal readCount As Long)
    cls04.ReadRecord = readCount
End Sub
Public Sub WriteErrorRecord(ByRef cls04 As Cls4_Log, ByVal errorCount As Long)
    cls04.ErrorRecord = errorCount
End Sub
Public Sub WriteProcessStatus(ByRef cls04 As Cls4_Log, ByVal status As String)
    cls04.ProcessStatus = status
End Sub
Public Sub WriteTimeSpent(ByRef cls04 As Cls4_Log, ByVal startTime As Double, ByVal endTime As Double)
    cls04.TimeSpent = endTime - startTime
End Sub
Public Sub WriteErrorRow(ByRef cls04 As Cls4_Log, ByVal errorRowNumber As Long)
    cls04.ErrorRow = errorRowNumber
End Sub
Public Sub WriteErrorReason(ByRef cls04 As Cls4_Log, ByVal errorContent As String)
    cls04.ErrorReason = errorContent
End Sub
Public Sub WriteRelevantData(ByRef cls04 As Cls4_Log, ByVal targetContent As String)
    cls04.RelevantData = targetContent
End Sub
