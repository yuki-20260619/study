VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
END
Attribute VB_Name = "Cls1_setting"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Option Explicit
Public Sub Setting(ByVal Enabled As Boolean)
    With Application
        .ScreenUpdating = Enabled ' 画面更新　停止：False／再開：True
        If Enabled = False Then
            .Calculation = xlCalculationManual ' 手動計算：False
        Else
            .Calculation = xlCalculationAutomatic ' 自動計算：True
        End If
        .EnableEvents = Enabled ' イベント　無効：False／有効：True
    End With
End Sub
Public Function StartTimer() As Double
    StartTimer = Timer
End Function
Public Function ProcessTime(startTime As Double) As Double
    Dim endTime As Double
    endTime = Timer
    
    ProcessTime = endTime - startTime
End Function
Public Sub ProtectBook(ByVal wb As Workbook, ByVal password As String, ByVal Enabled As Boolean)
    If Enabled = True Then '//True：保護を設定 / False：解除
        wb.Protect password
    Else
        wb.Unprotect password
    End If
    
    Set wb = Nothing
End Sub
Public Sub ProtectSheets(ByVal ws As Worksheet, ByVal password As String, ByVal Enabled As Boolean)
    With ws
        If Enabled = True Then '//True：保護を設定 / False：解除
            .EnableSelection = xlUnlockedCells '// ロックされたセルの選択を禁止する
            .Protect password
        Else
            .Unprotect password
        End If
    End With
    
    Set ws = Nothing
End Sub
