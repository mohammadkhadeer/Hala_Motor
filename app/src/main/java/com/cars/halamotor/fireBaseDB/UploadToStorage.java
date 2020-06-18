package com.cars.halamotor.fireBaseDB;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.cars.halamotor.model.AccAndJunk;
import com.cars.halamotor.model.CCEMT;
import com.cars.halamotor.model.CarPlatesModel;
import com.cars.halamotor.model.ItemCCEMT;
import com.cars.halamotor.model.WheelsRimModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.File;
import java.util.ArrayList;

import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.dataBase.InsertFunctions.insertNotificationTable;
import static com.cars.halamotor.fireBaseDB.FireBaseStoragePaths.carForSalePath;
import static com.cars.halamotor.fireBaseDB.InsertToFireBase.addNewItemToFireStore;
import static com.cars.halamotor.fireBaseDB.UploadModelsToFireBase.addNewAccessories;
import static com.cars.halamotor.fireBaseDB.UploadModelsToFireBase.addNewCarPlates;
import static com.cars.halamotor.fireBaseDB.UploadModelsToFireBase.addNewWheelsRim;
import static com.cars.halamotor.functions.Functions.getNotification;
import static com.cars.halamotor.functions.Functions.getTime;

public class UploadToStorage {

    public static void uploadImagesBeforeUploadCarForSaleModel(ArrayList<String> imagePaths, final ItemCCEMT itemCCEMT, String category
                                    , final String userIDOnServer, final int numberOfAds, final Context context) {
        //WE ADD timer cos no way to return imagePath after upload to server
        final ArrayList<String> imagePathsInServer = new ArrayList<String>();
        if (imagePaths.size() != 0)
        {
            for (int i=0;i<imagePaths.size();i++)
            {
                String imagePath = imagePaths.get(i);
                Uri imageUri = Uri.fromFile(new File(imagePath));

                final StorageReference storageReference = carForSalePath().child("image"+getTime()+String.valueOf(i));

                storageReference.putFile(imageUri).addOnSuccessListener
                        (new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        imagePathsInServer.add(String.valueOf(uri));
                                    }
                                });
                            }

                        });

            }
            new Handler().postDelayed(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void run() {
                    itemCCEMT.setImagePathArrayL(imagePathsInServer);
                    addNewItemToFireStore(itemCCEMT,"Car_For_Sale",userIDOnServer,numberOfAds,context);
                }
            }, 11000);
        }else{
            addNewItemToFireStore(itemCCEMT,"Car_For_Sale",userIDOnServer,numberOfAds,context);
            }
    }

    public static void uploadImagesBeforeUploadCarForRentModel(ArrayList<String> imagePaths
            , final ItemCCEMT itemCCEMT, String category
            , final String userIDOnServer, final int numberOfAds, final Context context) {
        //WE ADD timer cos no way to return imagePath after upload to server
        final ArrayList<String> imagePathsInServer = new ArrayList<String>();
        if (imagePaths.size() != 0)
        {
            for (int i=0;i<imagePaths.size();i++)
            {
                String imagePath = imagePaths.get(i);
                Uri imageUri = Uri.fromFile(new File(imagePath));

                final StorageReference storageReference = carForSalePath().child("image"+getTime()+String.valueOf(i));

                storageReference.putFile(imageUri).addOnSuccessListener
                        (new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        imagePathsInServer.add(String.valueOf(uri));
                                    }
                                });
                            }

                        });
            }

            new Handler().postDelayed(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void run() {
                    itemCCEMT.setImagePathArrayL(imagePathsInServer);
                    addNewItemToFireStore(itemCCEMT,"Car_For_Rent",userIDOnServer,numberOfAds,context);

                }
            }, 11000);
        }else{
            addNewItemToFireStore(itemCCEMT,"Car_For_Rent",userIDOnServer,numberOfAds,context);
        }
    }

    public static void uploadImagesBeforeUploadCarForExchangeModel(ArrayList<String> imagePaths
            , final ItemCCEMT itemCCEMT, String category
            , final String userIDOnServer, final int numberOfAds, final Context context) {
        //WE ADD timer cos no way to return imagePath after upload to server
        final ArrayList<String> imagePathsInServer = new ArrayList<String>();
        if (imagePaths.size() != 0)
        {
            for (int i=0;i<imagePaths.size();i++)
            {
                String imagePath = imagePaths.get(i);
                Uri imageUri = Uri.fromFile(new File(imagePath));

                final StorageReference storageReference = carForSalePath().child("image"+getTime()+String.valueOf(i));

                storageReference.putFile(imageUri).addOnSuccessListener
                        (new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        imagePathsInServer.add(String.valueOf(uri));
                                    }
                                });
                            }

                        });
            }

            new Handler().postDelayed(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void run() {
                    itemCCEMT.setImagePathArrayL(imagePathsInServer);
                    addNewItemToFireStore(itemCCEMT,"Car_For_Exchange",userIDOnServer,numberOfAds,context);
                }
            }, 11000);
        }else{
            addNewItemToFireStore(itemCCEMT,"Car_For_Exchange",userIDOnServer,numberOfAds,context);
        }
    }

    public static void uploadImagesBeforeUploadCarForMotorcycleModel(ArrayList<String> imagePaths
            , final ItemCCEMT itemCCEMT, String category
            , final String userIDOnServer, final int numberOfAds, final Context context) {
        //WE ADD timer cos no way to return imagePath after upload to server
        final ArrayList<String> imagePathsInServer = new ArrayList<String>();
        if (imagePaths.size() != 0)
        {
            for (int i=0;i<imagePaths.size();i++)
            {
                String imagePath = imagePaths.get(i);
                Uri imageUri = Uri.fromFile(new File(imagePath));

                final StorageReference storageReference = carForSalePath().child("image"+getTime()+String.valueOf(i));

                storageReference.putFile(imageUri).addOnSuccessListener
                        (new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        imagePathsInServer.add(String.valueOf(uri));
                                    }
                                });
                            }

                        });
            }

            new Handler().postDelayed(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void run() {
                    itemCCEMT.setImagePathArrayL(imagePathsInServer);
                    addNewItemToFireStore(itemCCEMT,"Motorcycle",userIDOnServer,numberOfAds,context);

                }
            }, 11000);
        }else{
            addNewItemToFireStore(itemCCEMT,"Motorcycle",userIDOnServer,numberOfAds,context);
        }
    }

    public static void uploadImagesBeforeUploadCarForTrucksModel(ArrayList<String> imagePaths
            , final ItemCCEMT itemCCEMT, String category
            , final String userIDOnServer, final int numberOfAds, final Context context) {
        //WE ADD timer cos no way to return imagePath after upload to server
        final ArrayList<String> imagePathsInServer = new ArrayList<String>();
        if (imagePaths.size() != 0)
        {
            for (int i=0;i<imagePaths.size();i++)
            {
                String imagePath = imagePaths.get(i);
                Uri imageUri = Uri.fromFile(new File(imagePath));

                final StorageReference storageReference = carForSalePath().child("image"+getTime()+String.valueOf(i));

                storageReference.putFile(imageUri).addOnSuccessListener
                        (new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        imagePathsInServer.add(String.valueOf(uri));
                                    }
                                });
                            }

                        });
            }

            new Handler().postDelayed(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void run() {
                    itemCCEMT.setImagePathArrayL(imagePathsInServer);
                    addNewItemToFireStore(itemCCEMT,"Trucks",userIDOnServer,numberOfAds,context);

                }
            }, 11000);
        }else{
            addNewItemToFireStore(itemCCEMT,"Trucks",userIDOnServer,numberOfAds,context);
        }
    }

    public static void uploadImagesBeforeUploadCarPlatesModel(ArrayList<String> imagePaths
            , final CarPlatesModel carPlatesModel, String category
            , final String userIDOnServer, final int numberOfAds, final Context context) {
        //WE ADD timer cos no way to return imagePath after upload to server
        final ArrayList<String> imagePathsInServer = new ArrayList<String>();
        if (imagePaths.size() != 0)
        {
            for (int i=0;i<imagePaths.size();i++)
            {
                String imagePath = imagePaths.get(i);
                Uri imageUri = Uri.fromFile(new File(imagePath));

                final StorageReference storageReference = carForSalePath().child("image"+getTime()+String.valueOf(i));

                storageReference.putFile(imageUri).addOnSuccessListener
                        (new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        imagePathsInServer.add(String.valueOf(uri));
                                    }
                                });
                            }

                        });
            }

            new Handler().postDelayed(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void run() {
                    carPlatesModel.setImagePathArrayL(imagePathsInServer);
                    addNewCarPlates(carPlatesModel,"Plates",userIDOnServer,numberOfAds,context);

                }
            }, 11000);
        }else{
            addNewCarPlates(carPlatesModel,"Plates",userIDOnServer,numberOfAds,context);
        }
    }

    public static void uploadImagesBeforeUploadWheelsRimModel(ArrayList<String> imagePaths
            , final WheelsRimModel wheelsRimModel, String category
            , final String userIDOnServer, final int numberOfAds, final Context context) {
        //WE ADD timer cos no way to return imagePath after upload to server
        final ArrayList<String> imagePathsInServer = new ArrayList<String>();
        if (imagePaths.size() != 0)
        {
            for (int i=0;i<imagePaths.size();i++)
            {
                String imagePath = imagePaths.get(i);
                Uri imageUri = Uri.fromFile(new File(imagePath));

                final StorageReference storageReference = carForSalePath().child("image"+getTime()+String.valueOf(i));

                storageReference.putFile(imageUri).addOnSuccessListener
                        (new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        imagePathsInServer.add(String.valueOf(uri));
                                    }
                                });
                            }

                        });
            }

            new Handler().postDelayed(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void run() {
                    wheelsRimModel.setImagePathArrayL(imagePathsInServer);
                    addNewWheelsRim(wheelsRimModel,"Wheels_Rim",userIDOnServer,numberOfAds,context);

                }
            }, 11000);
        }else{
            addNewWheelsRim(wheelsRimModel,"Wheels_Rim",userIDOnServer,numberOfAds,context);
        }
    }

    public static void uploadImagesBeforeUploadAccessoriesModel(ArrayList<String> imagePaths
            , final AccAndJunk accAndJunk, String category
            , final String userIDOnServer, final int numberOfAds, final Context context) {
        //WE ADD timer cos no way to return imagePath after upload to server
        final ArrayList<String> imagePathsInServer = new ArrayList<String>();
        if (imagePaths.size() != 0)
        {
            for (int i=0;i<imagePaths.size();i++)
            {
                String imagePath = imagePaths.get(i);
                Uri imageUri = Uri.fromFile(new File(imagePath));

                final StorageReference storageReference = carForSalePath().child("image"+getTime()+String.valueOf(i));

                storageReference.putFile(imageUri).addOnSuccessListener
                        (new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        imagePathsInServer.add(String.valueOf(uri));
                                    }
                                });
                            }

                        });
            }

            new Handler().postDelayed(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void run() {
                    accAndJunk.setImagePathArrayL(imagePathsInServer);
                    addNewAccessories(accAndJunk,"Accessories",userIDOnServer,numberOfAds,context);

                }
            }, 11000);
        }else{
            addNewAccessories(accAndJunk,"Accessories",userIDOnServer,numberOfAds,context);
        }
    }

    public static void uploadImagesBeforeUploadJunkCarModel(ArrayList<String> imagePaths
            , final AccAndJunk accAndJunk, String category
            , final String userIDOnServer, final int numberOfAds, final Context context) {
        //WE ADD timer cos no way to return imagePath after upload to server
        final ArrayList<String> imagePathsInServer = new ArrayList<String>();
        if (imagePaths.size() != 0)
        {
            for (int i=0;i<imagePaths.size();i++)
            {
                String imagePath = imagePaths.get(i);
                Uri imageUri = Uri.fromFile(new File(imagePath));

                final StorageReference storageReference = carForSalePath().child("image"+getTime()+String.valueOf(i));

                storageReference.putFile(imageUri).addOnSuccessListener
                        (new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        imagePathsInServer.add(String.valueOf(uri));
                                    }
                                });
                            }

                        });
            }

            new Handler().postDelayed(new Runnable() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void run() {
                    accAndJunk.setImagePathArrayL(imagePathsInServer);
                    addNewAccessories(accAndJunk,"JunkCar",userIDOnServer,numberOfAds,context);

                }
            }, 11000);
        }else{
            addNewAccessories(accAndJunk,"JunkCar",userIDOnServer,numberOfAds,context);
        }
    }

}