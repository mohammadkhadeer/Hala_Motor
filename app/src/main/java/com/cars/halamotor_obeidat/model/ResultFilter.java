package com.cars.halamotor_obeidat.model;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.List;

public class ResultFilter {
    List<SuggestedItem> resultItemsArrayList;
    List<DocumentSnapshot> documentSnapshotsArrayL;
    CollectionReference mRef;

    public ResultFilter(List<SuggestedItem> resultItemsArrayList, List<DocumentSnapshot> documentSnapshotsArrayL, CollectionReference mRef) {
        this.resultItemsArrayList = resultItemsArrayList;
        this.documentSnapshotsArrayL = documentSnapshotsArrayL;
        this.mRef = mRef;
    }

    public List<SuggestedItem> getResultItemsArrayList() {
        return resultItemsArrayList;
    }

    public void setResultItemsArrayList(List<SuggestedItem> resultItemsArrayList) {
        this.resultItemsArrayList = resultItemsArrayList;
    }

    public List<DocumentSnapshot> getDocumentSnapshotsArrayL() {
        return documentSnapshotsArrayL;
    }

    public void setDocumentSnapshotsArrayL(List<DocumentSnapshot> documentSnapshotsArrayL) {
        this.documentSnapshotsArrayL = documentSnapshotsArrayL;
    }

    public CollectionReference getmRef() {
        return mRef;
    }

    public void setmRef(CollectionReference mRef) {
        this.mRef = mRef;
    }
}
