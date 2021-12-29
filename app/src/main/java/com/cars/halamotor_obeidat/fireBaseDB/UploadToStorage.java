package com.cars.halamotor_obeidat.fireBaseDB;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;

import com.cars.halamotor_obeidat.model.ItemAccAndJunk;
import com.cars.halamotor_obeidat.model.ItemCCEMT;
import com.cars.halamotor_obeidat.model.ItemPlates;
import com.cars.halamotor_obeidat.model.ItemWheelsRim;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.File;
import java.util.ArrayList;

import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseStoragePaths.carForSalePath;
import static com.cars.halamotor_obeidat.fireBaseDB.InsertToFireBase.addAccessories;
import static com.cars.halamotor_obeidat.fireBaseDB.InsertToFireBase.addItemPlates;
import static com.cars.halamotor_obeidat.fireBaseDB.InsertToFireBase.addJunkCar;
import static com.cars.halamotor_obeidat.fireBaseDB.InsertToFireBase.addNewItemToFireStore;
import static com.cars.halamotor_obeidat.fireBaseDB.InsertToFireBase.addWheelsRim;
import static com.cars.halamotor_obeidat.functions.Functions.getTime;

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
            , final ItemPlates itemPlates, String category
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
                    itemPlates.setImagePathArrayL(imagePathsInServer);
                    addItemPlates(itemPlates,userIDOnServer,numberOfAds,context);

                }
            }, 11000);
        }else{
            addItemPlates(itemPlates,userIDOnServer,numberOfAds,context);
        }
    }

    public static void uploadImagesBeforeUploadWheelsRimModel(ArrayList<String> imagePaths
            , final ItemWheelsRim wheelsRimModel, String category
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
                    addWheelsRim(wheelsRimModel,userIDOnServer,numberOfAds,context);

                }
            }, 11000);
        }else{
            addWheelsRim(wheelsRimModel,userIDOnServer,numberOfAds,context);
        }
    }

    public static void uploadImagesBeforeUploadAccessoriesModel(ArrayList<String> imagePaths
            , final ItemAccAndJunk itemAccAndJunk, String category
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
                    itemAccAndJunk.setImagePathArrayL(imagePathsInServer);
                    addAccessories(itemAccAndJunk,userIDOnServer,numberOfAds,context);

                }
            }, 11000);
        }else{
            addAccessories(itemAccAndJunk,userIDOnServer,numberOfAds,context);
        }
    }

    public static void uploadImagesBeforeUploadJunkCarModel(ArrayList<String> imagePaths
            , final ItemAccAndJunk accAndJunk, String category
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
                    addJunkCar(accAndJunk,userIDOnServer,numberOfAds,context);

                }
            }, 11000);
        }else{
            addJunkCar(accAndJunk,userIDOnServer,numberOfAds,context);
        }
    }

}