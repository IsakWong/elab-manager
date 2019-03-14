package elab.database;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;

public abstract class Session<ReturnType> implements SessionCallback<ReturnType> {

    public boolean IsSending = false;

    public class SessionResult<ReturnType> {
        public ReturnType result;
        public String errorMessage;
    }

    SessionResult<ReturnType> sessionResult = new SessionResult<>();

    ObservableOnSubscribe<SessionResult> observer = new ObservableOnSubscribe<SessionResult>() {
        @Override
        public void subscribe(ObservableEmitter<SessionResult> observableEmitter) throws Exception {
            Session.this.onPostFetchResult(sessionResult);
            observableEmitter.onNext(sessionResult);
            observableEmitter.onComplete();
        }
    };

    Observer<SessionResult> subscriber = new Observer<SessionResult>() {
        @Override
        public void onSubscribe(Disposable disposable) {

        }

        @Override
        public void onNext(SessionResult returnType) {
            if (returnType.result != null)
                Session.this.onSuccess(sessionResult.result);
            else
                Session.this.onError(returnType.errorMessage);
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onComplete() {

        }
    };

    public void send() {

        if (IsSending == false) {
            IsSending = true;
            Observable.create(observer)
                    .subscribeOn(Schedulers.io())
                    .observeOn(JavaFxScheduler.platform())
                    .subscribe(subscriber);
        } else {
            this.onBusy();
        }
    }
}
