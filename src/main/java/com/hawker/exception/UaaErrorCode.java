package com.hawker.exception;

public enum UaaErrorCode implements ErrorCode {

    //连接错误
    NET_WORK_UNAVAIBLE("NetworkErrCode-00","网络连接失败"),
    PARAMETER_ERROR("ParameterErrCode-00","参数不正确，请重新输入"),
    DEVISION_ERROR("DevisionErrCode-00","除0异常"),
    MYSQL_CONN_WORK_UNAVAIBLE("MYSQLErrCode-00","数据库连接失败，请联系系统管理员"),
    MYSQL_CONN_USERPWD_ERROR("MYSQLErrCode-01","数据库用户名或者密码错误，请检查填写的账号密码或者联系DBA确认账号和密码是否正确"),
    MYSQL_CONN_IPPORT_ERROR("MYSQLErrCode-02","数据库服务的IP地址或者Port错误，请检查填写的IP地址和Port或者联系DBA确认IP地址和Port是否正确。如果是同步中心用户请联系DBA确认idb上录入的IP和PORT信息和数据库的当前实际信息是一致的"),
    MYSQL_CONN_DB_ERROR("MYSQLErrCode-03","数据库名称错误，请检查数据库实例名称或者联系DBA确认该实例是否存在并且在正常服务"),
    HOOK_INTERNAL_ERROR("Common-12", "Hook运行错误 ."),
    SHUT_DOWN_TASK("Common-20", "Task收到了shutdown指令，为failover做准备"),
    WAIT_TIME_EXCEED("Common-21", "等待时间超出范围");

    private final String code;

    private final String description;

    private UaaErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return String.format("ErrCode:[%s], Description:[%s]. ", this.code,
                this.description);
    }
}
