package qalsdk;

public enum m {
    connInit,
    connStarting,
    connSucc,
    connClosing,
    connClosed,
    interrupted,
    connError_illegalargument,
    connError_enotsock,
    connError_permission,
    connError_ebadFileNum,
    connError_errno,
    connError_enobufs,
    connError_unreachable,
    connError_invalidArgument,
    connError_unresolved,
    connError_unknownhost,
    connError_noroute,
    connError_reset,
    connError_refused,
    connError_timeout,
    connError_unknown,
    recvSsoRespSucc,
    decodeSsoRespError,
    recvSsoData,
    recvSsoDataError;

    static {
        connInit = new m("connInit", 0);
        connStarting = new m("connStarting", 1);
        connSucc = new m("connSucc", 2);
        connClosing = new m("connClosing", 3);
        connClosed = new m("connClosed", 4);
        interrupted = new m("interrupted", 5);
        connError_illegalargument = new m("connError_illegalargument", 6);
        connError_enotsock = new m("connError_enotsock", 7);
        connError_permission = new m("connError_permission", 8);
        connError_ebadFileNum = new m("connError_ebadFileNum", 9);
        connError_errno = new m("connError_errno", 10);
        connError_enobufs = new m("connError_enobufs", 11);
        connError_unreachable = new m("connError_unreachable", 12);
        connError_invalidArgument = new m("connError_invalidArgument", 13);
        connError_unresolved = new m("connError_unresolved", 14);
        connError_unknownhost = new m("connError_unknownhost", 15);
        connError_noroute = new m("connError_noroute", 16);
        connError_reset = new m("connError_reset", 17);
        connError_refused = new m("connError_refused", 18);
        connError_timeout = new m("connError_timeout", 19);
        connError_unknown = new m("connError_unknown", 20);
        recvSsoRespSucc = new m("recvSsoRespSucc", 21);
        decodeSsoRespError = new m("decodeSsoRespError", 22);
        recvSsoData = new m("recvSsoData", 23);
        recvSsoDataError = new m("recvSsoDataError", 24);
        m[] mVarArr = {connInit, connStarting, connSucc, connClosing, connClosed, interrupted, connError_illegalargument, connError_enotsock, connError_permission, connError_ebadFileNum, connError_errno, connError_enobufs, connError_unreachable, connError_invalidArgument, connError_unresolved, connError_unknownhost, connError_noroute, connError_reset, connError_refused, connError_timeout, connError_unknown, recvSsoRespSucc, decodeSsoRespError, recvSsoData, recvSsoDataError};
    }
}
