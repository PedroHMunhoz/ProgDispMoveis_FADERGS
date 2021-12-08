package br.com.pedrohmunhoz.appfinancas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "AppFinancas_SQLite";
    private static final int VERSAO = 2;

    public Conexao(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS usuario (" +
                "id TEXT NOT NULL PRIMARY KEY," +
                "nome TEXT," +
                "email TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("CREATE TABLE IF NOT EXISTS lancamento (" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "usuario_id TEXT NOT NULL," +
                    "descricao TEXT," +
                    "tipoLancamento INT NOT NULL," +
                    "valor DOUBLE NOT NULL," +
                    "data DATE NOT NULL)");
    }
}
