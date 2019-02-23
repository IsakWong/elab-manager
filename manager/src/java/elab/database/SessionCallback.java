package elab.database;


public interface SessionCallback<ParamType>{
    void onPostFetchResult(Session<ParamType>.SessionResult<ParamType> sessionResult);
    void onSuccess(ParamType param);
    void onError(String errorMessage);
    void onBusy();
}

