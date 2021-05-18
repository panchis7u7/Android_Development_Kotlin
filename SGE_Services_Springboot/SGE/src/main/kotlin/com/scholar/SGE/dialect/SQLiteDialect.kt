package com.scholar.SGE.dialect

import org.hibernate.dialect.Dialect
import org.hibernate.dialect.function.StandardSQLFunction
import org.hibernate.dialect.function.SQLFunctionTemplate
import org.hibernate.dialect.function.VarArgsSQLFunction
import org.hibernate.Hibernate
import org.hibernate.type.StringType
import java.sql.Types

class SQLiteDialect: Dialect{
    constructor(){
        registerColumnType(Types.BIT, "integer");
        registerColumnType(Types.TINYINT, "tinyint");
        registerColumnType(Types.SMALLINT, "smallint");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.BIGINT, "bigint");
        registerColumnType(Types.FLOAT, "float");
        registerColumnType(Types.REAL, "real");
        registerColumnType(Types.DOUBLE, "double");
        registerColumnType(Types.NUMERIC, "numeric");
        registerColumnType(Types.DECIMAL, "decimal");
        registerColumnType(Types.CHAR, "char");
        registerColumnType(Types.VARCHAR, "varchar");
        registerColumnType(Types.LONGVARCHAR, "longvarchar");
        registerColumnType(Types.DATE, "date");
        registerColumnType(Types.TIME, "time");
        registerColumnType(Types.TIMESTAMP, "timestamp");
        registerColumnType(Types.BINARY, "blob");
        registerColumnType(Types.VARBINARY, "blob");
        registerColumnType(Types.LONGVARBINARY, "blob");
        // registerColumnType(Types.NULL, "null");
        registerColumnType(Types.BLOB, "blob");
        registerColumnType(Types.CLOB, "clob");
        registerColumnType(Types.BOOLEAN, "integer");
 
        registerFunction("concat", VarArgsSQLFunction(StringType.INSTANCE, "", "||", ""));
        registerFunction("mod", SQLFunctionTemplate(StringType.INSTANCE, "?1 % ?2"));
        registerFunction("substr", StandardSQLFunction("substr", StringType.INSTANCE));
        registerFunction("substring", StandardSQLFunction("substr", StringType.INSTANCE));
    }

    public fun supportsIdentityColumns(): Boolean {
        return true;
    }
 
    public fun hasDataTypeInIdentityColumn(): Boolean {
        return false; // As specify in NHibernate dialect
    }
 
    public fun getIdentityColumnString(): String {
        // return "integer primary key autoincrement";
        return "integer";
    }
 
    public fun getIdentitySelectString(): String {
        return "select last_insert_rowid()";
    }
 
    public override fun supportsLimit(): Boolean {
        return true;
    }
 
    protected override fun getLimitString(query: String, hasOffset: Boolean): String {
        return StringBuffer(query.length + 20).append(query).append(if (hasOffset) " limit ? offset ?" else " limit ?")
        .toString();
    }
 
    public fun supportsTemporaryTables(): Boolean {
        return true;
    }
 
    public fun getCreateTemporaryTableString(): String {
        return "create temporary table if not exists";
    }
 
    public fun dropTemporaryTableAfterUse(): Boolean {
        return false;
    }
 
    public override fun supportsCurrentTimestampSelection(): Boolean {
        return true;
    }
 
    public override fun isCurrentTimestampSelectStringCallable(): Boolean {
        return false;
    }
 
    public override fun getCurrentTimestampSelectString(): String {
        return "select current_timestamp";
    }
 
    public override fun supportsUnionAll(): Boolean {
        return true;
    }
 
    public override fun hasAlterTable(): Boolean {
        return false; // As specify in NHibernate dialect
    }
 
    public override fun dropConstraints(): Boolean {
        return false;
    }
 
    public override fun getAddColumnString(): String {
        return "add column";
    }
 
    public override fun getForUpdateString(): String {
        return "";
    }
 
    public override fun supportsOuterJoinForUpdate(): Boolean {
        return false;
    }
 
    public override fun getDropForeignKeyString(): String {
        throw UnsupportedOperationException("No drop foreign key syntax supported by SQLiteDialect")
    }
 
    public override fun getAddForeignKeyConstraintString(constraintName: String, foreignKey: Array<String>, referencedTable: String,
            primaryKey: Array<String>, referencesPrimaryKey: Boolean): String {
        throw UnsupportedOperationException("No add foreign key syntax supported by SQLiteDialect")
    }
 
    public override fun getAddPrimaryKeyConstraintString(constraintName: String): String {
        throw UnsupportedOperationException("No add primary key syntax supported by SQLiteDialect")
    }
 
    public override fun supportsIfExistsBeforeTableName(): Boolean {
        return true
    }
 
    public override fun supportsCascadeDelete(): Boolean {
        return false
    }
}