    # 実技課題 「bookstoreデータベースを挿入しよう」
    / *
     演習問題では、サンプルデータベースとして講座で用いているSakilaではなくbookstoreデータベースを使用します。
     bookstoreデータベースのテーブルを作成するSQLファイルは `/home/ubuntu/bookstore-schema.sql` に、データを挿入するSQLファイルは `/home/ubuntu/bookstore-data.sql` に存在します。
     MySQLに接続し、sourceコマンドを使ってこれらのSQLファイルをMySQLに読み込ませてください。
    */
    mysql -u root
    source /home/ubuntu/bookstore-schema.sql
    source /home/ubuntu/bookstore-data.sql

