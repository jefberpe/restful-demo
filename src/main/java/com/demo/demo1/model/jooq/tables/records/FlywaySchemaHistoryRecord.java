/*
 * This file is generated by jOOQ.
 */
package com.demo.demo1.model.jooq.tables.records;


import com.demo.demo1.model.jooq.tables.FlywaySchemaHistory;

import java.sql.Timestamp;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FlywaySchemaHistoryRecord extends UpdatableRecordImpl<FlywaySchemaHistoryRecord> implements Record10<Integer, String, String, String, String, Integer, String, Timestamp, Integer, Boolean> {

    private static final long serialVersionUID = -1754969363;

    /**
     * Setter for <code>public.flyway_schema_history.installed_rank</code>.
     */
    public void setInstalledRank(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.installed_rank</code>.
     */
    public Integer getInstalledRank() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.flyway_schema_history.version</code>.
     */
    public void setVersion(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.version</code>.
     */
    public String getVersion() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.flyway_schema_history.description</code>.
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.flyway_schema_history.type</code>.
     */
    public void setType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.type</code>.
     */
    public String getType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.flyway_schema_history.script</code>.
     */
    public void setScript(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.script</code>.
     */
    public String getScript() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.flyway_schema_history.checksum</code>.
     */
    public void setChecksum(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.checksum</code>.
     */
    public Integer getChecksum() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.flyway_schema_history.installed_by</code>.
     */
    public void setInstalledBy(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.installed_by</code>.
     */
    public String getInstalledBy() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.flyway_schema_history.installed_on</code>.
     */
    public void setInstalledOn(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.installed_on</code>.
     */
    public Timestamp getInstalledOn() {
        return (Timestamp) get(7);
    }

    /**
     * Setter for <code>public.flyway_schema_history.execution_time</code>.
     */
    public void setExecutionTime(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.execution_time</code>.
     */
    public Integer getExecutionTime() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.flyway_schema_history.success</code>.
     */
    public void setSuccess(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.success</code>.
     */
    public Boolean getSuccess() {
        return (Boolean) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Integer, String, String, String, String, Integer, String, Timestamp, Integer, Boolean> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Integer, String, String, String, String, Integer, String, Timestamp, Integer, Boolean> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SCRIPT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.CHECKSUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_ON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.EXECUTION_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field10() {
        return FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getInstalledRank();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getScript();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getChecksum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getInstalledBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component8() {
        return getInstalledOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getExecutionTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component10() {
        return getSuccess();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getInstalledRank();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getScript();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getChecksum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getInstalledBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getInstalledOn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getExecutionTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value10() {
        return getSuccess();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FlywaySchemaHistoryRecord value1(Integer value) {
        setInstalledRank(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FlywaySchemaHistoryRecord value2(String value) {
        setVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FlywaySchemaHistoryRecord value3(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FlywaySchemaHistoryRecord value4(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FlywaySchemaHistoryRecord value5(String value) {
        setScript(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FlywaySchemaHistoryRecord value6(Integer value) {
        setChecksum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FlywaySchemaHistoryRecord value7(String value) {
        setInstalledBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FlywaySchemaHistoryRecord value8(Timestamp value) {
        setInstalledOn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FlywaySchemaHistoryRecord value9(Integer value) {
        setExecutionTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FlywaySchemaHistoryRecord value10(Boolean value) {
        setSuccess(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FlywaySchemaHistoryRecord values(Integer value1, String value2, String value3, String value4, String value5, Integer value6, String value7, Timestamp value8, Integer value9, Boolean value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FlywaySchemaHistoryRecord
     */
    public FlywaySchemaHistoryRecord() {
        super(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY);
    }

    /**
     * Create a detached, initialised FlywaySchemaHistoryRecord
     */
    public FlywaySchemaHistoryRecord(Integer installedRank, String version, String description, String type, String script, Integer checksum, String installedBy, Timestamp installedOn, Integer executionTime, Boolean success) {
        super(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY);

        set(0, installedRank);
        set(1, version);
        set(2, description);
        set(3, type);
        set(4, script);
        set(5, checksum);
        set(6, installedBy);
        set(7, installedOn);
        set(8, executionTime);
        set(9, success);
    }
}
