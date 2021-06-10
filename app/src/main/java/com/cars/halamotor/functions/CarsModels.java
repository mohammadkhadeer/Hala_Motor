package com.cars.halamotor.functions;

import android.content.Context;

import com.cars.halamotor.R;
import com.cars.halamotor.model.CarModel;

import java.util.ArrayList;

public class CarsModels {

//    public static ArrayList<CarModel> fillCarHyundaiArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.h_1_starex),context.getString(R.string.h_1_starex_s),context.getString(R.string.h_1_starex_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.i_10),context.getString(R.string.i_10_s),context.getString(R.string.i_10_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.i_20),context.getString(R.string.i_20_s),context.getString(R.string.i_20_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.i_30),context.getString(R.string.i_30_s),context.getString(R.string.i_30_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.i_40),context.getString(R.string.i_40_s),context.getString(R.string.i_40_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.atos),context.getString(R.string.atos_s),context.getString(R.string.atos_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.azera),context.getString(R.string.azera_s),context.getString(R.string.azera_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.accent),context.getString(R.string.accent_s),context.getString(R.string.accent_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.h_100),context.getString(R.string.h_100_s),context.getString(R.string.h_100_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.excel),context.getString(R.string.excel_s),context.getString(R.string.excel_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.elantra),context.getString(R.string.elantra_s),context.getString(R.string.elantra_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.avante),context.getString(R.string.avante_s),context.getString(R.string.avante_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.equus),context.getString(R.string.equus_s),context.getString(R.string.equus_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.ioniq),context.getString(R.string.ioniq_s),context.getString(R.string.ioniq_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porter),context.getString(R.string.porter_s),context.getString(R.string.porter_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pony),context.getString(R.string.pony_s),context.getString(R.string.pony_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.trajet),context.getString(R.string.trajet_s),context.getString(R.string.trajet_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.tuscani),context.getString(R.string.tuscani_s),context.getString(R.string.tuscani_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.terracan),context.getString(R.string.terracan_s),context.getString(R.string.terracan_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.tiburon),context.getString(R.string.tiburon_s),context.getString(R.string.tiburon_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.galloper),context.getString(R.string.galloper_s),context.getString(R.string.galloper_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.getz),context.getString(R.string.getz_s),context.getString(R.string.getz_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.genesis),context.getString(R.string.genesis_s),context.getString(R.string.genesis_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.genesis_coupe),context.getString(R.string.genesis_coupe_s),context.getString(R.string.genesis_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.santamo),context.getString(R.string.santamo_s),context.getString(R.string.santamo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.stellar),context.getString(R.string.stellar_s),context.getString(R.string.stellar_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.scoupe),context.getString(R.string.scoupe_s),context.getString(R.string.scoupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.santa_fe),context.getString(R.string.santa_fe_s),context.getString(R.string.santa_fe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.centennial),context.getString(R.string.centennial_s),context.getString(R.string.centennial_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.sonata),context.getString(R.string.sonata_s),context.getString(R.string.sonata_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.veloster),context.getString(R.string.veloster_s),context.getString(R.string.veloster_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.veracruz),context.getString(R.string.veracruz_s),context.getString(R.string.veracruz_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.verna),context.getString(R.string.verna_s),context.getString(R.string.verna_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.creta),context.getString(R.string.creta_s),context.getString(R.string.creta_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.coupe),context.getString(R.string.coupe_s),context.getString(R.string.coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.matrix),context.getString(R.string.matrix_s),context.getString(R.string.matrix_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mighty),context.getString(R.string.mighty_s),context.getString(R.string.mighty_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kona),context.getString(R.string.kona_s),context.getString(R.string.kona_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.eon),context.getString(R.string.eon_s),context.getString(R.string.eon_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.palisade),context.getString(R.string.palisade_s),context.getString(R.string.palisade_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.click),context.getString(R.string.click_s),context.getString(R.string.click_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.entourage),context.getString(R.string.entourage_s),context.getString(R.string.entourage_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.county),context.getString(R.string.county_s),context.getString(R.string.county_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarToyotaArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_4runner),context.getString(R.string.toyota_4runner_s),context.getString(R.string.toyota_4runner_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_c_hr),context.getString(R.string.toyota_c_hr_s),context.getString(R.string.toyota_c_hr_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_mr2),context.getString(R.string.toyota_mr2_s),context.getString(R.string.toyota_mr2_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_iq),context.getString(R.string.toyota_iq_s),context.getString(R.string.toyota_iq_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_avalon),context.getString(R.string.toyota_avalon_s),context.getString(R.string.toyota_avalon_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_avanza),context.getString(R.string.toyota_avanza_s),context.getString(R.string.toyota_avanza_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_avensis),context.getString(R.string.toyota_avensis_s),context.getString(R.string.toyota_avensis_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_alphard),context.getString(R.string.toyota_alphard_s),context.getString(R.string.toyota_alphard_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_allex),context.getString(R.string.toyota_allex_s),context.getString(R.string.toyota_allex_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_opa),context.getString(R.string.toyota_opa_s),context.getString(R.string.toyota_opa_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_auris),context.getString(R.string.toyota_auris_s),context.getString(R.string.toyota_auris_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_echo),context.getString(R.string.toyota_echo_s),context.getString(R.string.toyota_echo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_innova),context.getString(R.string.toyota_innova_s),context.getString(R.string.toyota_innova_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_aristo),context.getString(R.string.toyota_aristo_s),context.getString(R.string.toyota_aristo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_fj_cruiser),context.getString(R.string.toyota_fj_cruiser_s),context.getString(R.string.toyota_fj_cruiser_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_mark_x),context.getString(R.string.toyota_mark_x_s),context.getString(R.string.toyota_mark_x_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_altezza),context.getString(R.string.toyota_altezza_s),context.getString(R.string.toyota_altezza_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_allion),context.getString(R.string.toyota_allion_s),context.getString(R.string.toyota_allion_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_urban_cruiser),context.getString(R.string.toyota_urban_cruiser_s),context.getString(R.string.toyota_urban_cruiser_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_orgin),context.getString(R.string.toyota_orgin_s),context.getString(R.string.toyota_orgin_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_aurion),context.getString(R.string.toyota_aurion_s),context.getString(R.string.toyota_aurion_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_ipsum),context.getString(R.string.toyota_ipsum_s),context.getString(R.string.toyota_ipsum_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_aygo),context.getString(R.string.toyota_aygo_s),context.getString(R.string.toyota_aygo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_passo),context.getString(R.string.toyota_passo_s),context.getString(R.string.toyota_passo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_paseo),context.getString(R.string.toyota_paseo_s),context.getString(R.string.toyota_paseo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_prado),context.getString(R.string.toyota_prado_s),context.getString(R.string.toyota_prado_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_probox),context.getString(R.string.toyota_probox_s),context.getString(R.string.toyota_probox_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_progres),context.getString(R.string.toyota_progres_s),context.getString(R.string.toyota_progres_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_pronard),context.getString(R.string.toyota_pronard_s),context.getString(R.string.toyota_pronard_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_previa),context.getString(R.string.toyota_previa_s),context.getString(R.string.toyota_previa_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_premio),context.getString(R.string.toyota_premio_s),context.getString(R.string.toyota_premio_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_prius),context.getString(R.string.toyota_prius_s),context.getString(R.string.toyota_prius_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_prius_c),context.getString(R.string.toyota_prius_c_s),context.getString(R.string.toyota_prius_c_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_blade),context.getString(R.string.toyota_blade_s),context.getString(R.string.toyota_blade_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_blizzard),context.getString(R.string.toyota_blizzard_s),context.getString(R.string.toyota_blizzard_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_porte),context.getString(R.string.toyota_porte_s),context.getString(R.string.toyota_porte_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_bb),context.getString(R.string.toyota_bb_s),context.getString(R.string.toyota_bb_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_picnic),context.getString(R.string.toyota_picnic_s),context.getString(R.string.toyota_picnic_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_tacoma),context.getString(R.string.toyota_tacoma_s),context.getString(R.string.toyota_tacoma_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_townace),context.getString(R.string.toyota_townace_s),context.getString(R.string.toyota_townace_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_chaser),context.getString(R.string.toyota_chaser_s),context.getString(R.string.toyota_chaser_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_tundra),context.getString(R.string.toyota_tundra_s),context.getString(R.string.toyota_tundra_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_tercel),context.getString(R.string.toyota_tercel_s),context.getString(R.string.toyota_tercel_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_grand_hiace),context.getString(R.string.toyota_grand_hiace_s),context.getString(R.string.toyota_grand_hiace_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_gt_86),context.getString(R.string.toyota_gt_86_s),context.getString(R.string.toyota_gt_86_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_duet),context.getString(R.string.toyota_duet_s),context.getString(R.string.toyota_duet_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_dyna),context.getString(R.string.toyota_dyna_s),context.getString(R.string.toyota_dyna_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_rav_4),context.getString(R.string.toyota_rav_4_s),context.getString(R.string.toyota_rav_4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_ractis),context.getString(R.string.toyota_ractis_s),context.getString(R.string.toyota_ractis_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_raum),context.getString(R.string.toyota_raum_s),context.getString(R.string.toyota_raum_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_rush),context.getString(R.string.toyota_rush_s),context.getString(R.string.toyota_rush_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_regius),context.getString(R.string.toyota_regius_s),context.getString(R.string.toyota_regius_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_zelas),context.getString(R.string.toyota_zelas_s),context.getString(R.string.toyota_zelas_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_sparky),context.getString(R.string.toyota_sparky_s),context.getString(R.string.toyota_sparky_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_sprinter),context.getString(R.string.toyota_sprinter_s),context.getString(R.string.toyota_sprinter_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_starlet),context.getString(R.string.toyota_starlet_s),context.getString(R.string.toyota_starlet_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_succeed),context.getString(R.string.toyota_succeed_s),context.getString(R.string.toyota_succeed_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_scepter),context.getString(R.string.toyota_scepter_s),context.getString(R.string.toyota_scepter_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_supra),context.getString(R.string.toyota_supra_s),context.getString(R.string.toyota_supra_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_soarer),context.getString(R.string.toyota_soarer_s),context.getString(R.string.toyota_soarer_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_soluna),context.getString(R.string.toyota_soluna_s),context.getString(R.string.toyota_soluna_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_sera),context.getString(R.string.toyota_sera_s),context.getString(R.string.toyota_sera_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_sequoia),context.getString(R.string.toyota_sequoia_s),context.getString(R.string.toyota_sequoia_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_celsior),context.getString(R.string.toyota_celsior_s),context.getString(R.string.toyota_celsior_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_sequoia),context.getString(R.string.toyota_sequoia_s),context.getString(R.string.toyota_sequoia_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_celsior),context.getString(R.string.toyota_celsior_s),context.getString(R.string.toyota_celsior_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_celica),context.getString(R.string.toyota_celica_s),context.getString(R.string.toyota_celica_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_sienta),context.getString(R.string.toyota_sienta_s),context.getString(R.string.toyota_sienta_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_scion),context.getString(R.string.toyota_scion_s),context.getString(R.string.toyota_scion_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_sienna),context.getString(R.string.toyota_sienna_s),context.getString(R.string.toyota_sienna_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_land_cruiser_pickup),context.getString(R.string.toyota_land_cruiser_pickup_s),context.getString(R.string.toyota_land_cruiser_pickup_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_gaia),context.getString(R.string.toyota_gaia_s),context.getString(R.string.toyota_gaia_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_granvia),context.getString(R.string.toyota_granvia_s),context.getString(R.string.toyota_granvia_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_vellfire),context.getString(R.string.toyota_vellfire_s),context.getString(R.string.toyota_vellfire_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_venza),context.getString(R.string.toyota_venza_s),context.getString(R.string.toyota_venza_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_fun_cargo),context.getString(R.string.toyota_fun_cargo_s),context.getString(R.string.toyota_fun_cargo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_fortuner),context.getString(R.string.toyota_fortuner_s),context.getString(R.string.toyota_fortuner_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_voxy),context.getString(R.string.toyota_voxy_s),context.getString(R.string.toyota_voxy_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_voltz),context.getString(R.string.toyota_voltz_s),context.getString(R.string.toyota_voltz_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_verso),context.getString(R.string.toyota_verso_s),context.getString(R.string.toyota_verso_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_carina),context.getString(R.string.toyota_carina_s),context.getString(R.string.toyota_carina_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_cavalier),context.getString(R.string.toyota_cavalier_s),context.getString(R.string.toyota_cavalier_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_caldina),context.getString(R.string.toyota_caldina_s),context.getString(R.string.toyota_caldina_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_camry),context.getString(R.string.toyota_camry_s),context.getString(R.string.toyota_camry_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_crown),context.getString(R.string.toyota_crown_s),context.getString(R.string.toyota_crown_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_cressida),context.getString(R.string.toyota_cressida_s),context.getString(R.string.toyota_cressida_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_corolla),context.getString(R.string.toyota_corolla_s),context.getString(R.string.toyota_corolla_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_Corona),context.getString(R.string.toyota_Corona_s),context.getString(R.string.toyota_Corona_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_coaster),context.getString(R.string.toyota_coaster_s),context.getString(R.string.toyota_coaster_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_land_cruiser),context.getString(R.string.toyota_land_cruiser_s),context.getString(R.string.toyota_land_cruiser_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_land_cruiser_j70),context.getString(R.string.toyota_land_cruiser_j70_s),context.getString(R.string.toyota_land_cruiser_j70_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_liteAce),context.getString(R.string.toyota_liteAce_s),context.getString(R.string.toyota_liteAce_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_matrix),context.getString(R.string.toyota_matrix_s),context.getString(R.string.toyota_matrix_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_mark_2),context.getString(R.string.toyota_mark_2_s),context.getString(R.string.toyota_mark_2_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_master_ace),context.getString(R.string.toyota_master_ace_s),context.getString(R.string.toyota_master_ace_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_mega_cruiser),context.getString(R.string.toyota_mega_cruiser_s),context.getString(R.string.toyota_mega_cruiser_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_harrier),context.getString(R.string.toyota_harrier_s),context.getString(R.string.toyota_harrier_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_hiace),context.getString(R.string.toyota_hiace_s),context.getString(R.string.toyota_hiace_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_highlander),context.getString(R.string.toyota_highlander_s),context.getString(R.string.toyota_highlander_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_hilux),context.getString(R.string.toyota_hilux_s),context.getString(R.string.toyota_hilux_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_wish),context.getString(R.string.toyota_wish_s),context.getString(R.string.toyota_wish_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_will),context.getString(R.string.toyota_will_s),context.getString(R.string.toyota_will_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_windom),context.getString(R.string.toyota_windom_s),context.getString(R.string.toyota_windom_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_yaris),context.getString(R.string.toyota_yaris_s),context.getString(R.string.toyota_yaris_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_2000_gt),context.getString(R.string.toyota_2000_gt_s),context.getString(R.string.toyota_2000_gt_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_ai_300),context.getString(R.string.toyota_ai_300_s),context.getString(R.string.toyota_ai_300_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_will),context.getString(R.string.toyota_will_s),context.getString(R.string.toyota_will_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_axio),context.getString(R.string.toyota_axio_s),context.getString(R.string.toyota_axio_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_celstar),context.getString(R.string.toyota_celstar_s),context.getString(R.string.toyota_celstar_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_corolla),context.getString(R.string.toyota_corolla_s),context.getString(R.string.toyota_corolla_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_fielder),context.getString(R.string.toyota_fielder_s),context.getString(R.string.toyota_fielder_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_noah),context.getString(R.string.toyota_noah_s),context.getString(R.string.toyota_noah_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_rumion),context.getString(R.string.toyota_rumion_s),context.getString(R.string.toyota_rumion_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_runx),context.getString(R.string.toyota_runx_s),context.getString(R.string.toyota_runx_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_solara),context.getString(R.string.toyota_solara_s),context.getString(R.string.toyota_solara_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_sprinter_carib),context.getString(R.string.toyota_sprinter_carib_s),context.getString(R.string.toyota_sprinter_carib_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_vanguard),context.getString(R.string.toyota_vanguard_s),context.getString(R.string.toyota_vanguard_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.toyota_verossa),context.getString(R.string.toyota_verossa_s),context.getString(R.string.toyota_verossa_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarKiaArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_asia),context.getString(R.string.kia_asia_s),context.getString(R.string.kia_asia_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_avila),context.getString(R.string.kia_avila_s),context.getString(R.string.kia_avila_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_optima),context.getString(R.string.kia_optima_s),context.getString(R.string.kia_optima_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_opirus),context.getString(R.string.kia_opirus_s),context.getString(R.string.kia_opirus_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_elan),context.getString(R.string.kia_elan_s),context.getString(R.string.kia_elan_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_pride),context.getString(R.string.kia_pride_s),context.getString(R.string.kia_pride_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_borrego),context.getString(R.string.kia_borrego_s),context.getString(R.string.kia_borrego_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_bongo),context.getString(R.string.kia_bongo_s),context.getString(R.string.kia_bongo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_besta),context.getString(R.string.kia_besta_s),context.getString(R.string.kia_besta_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_picanto),context.getString(R.string.kia_picanto_s),context.getString(R.string.kia_picanto_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_granbird),context.getString(R.string.kia_granbird_s),context.getString(R.string.kia_granbird_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_joice),context.getString(R.string.kia_joice_s),context.getString(R.string.kia_joice_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_retona),context.getString(R.string.kia_retona_s),context.getString(R.string.kia_retona_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_rio),context.getString(R.string.kia_rio_s),context.getString(R.string.kia_rio_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_sportage),context.getString(R.string.kia_sportage_s),context.getString(R.string.kia_sportage_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_spectra),context.getString(R.string.kia_spectra_s),context.getString(R.string.kia_spectra_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_sorento),context.getString(R.string.kia_sorento_s),context.getString(R.string.kia_sorento_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_soul),context.getString(R.string.kia_soul_s),context.getString(R.string.kia_soul_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_cerato),context.getString(R.string.kia_cerato_s),context.getString(R.string.kia_cerato_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_cerato_koup),context.getString(R.string.kia_cerato_koup_s),context.getString(R.string.kia_cerato_koup_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_sephia),context.getString(R.string.kia_sephia_s),context.getString(R.string.kia_sephia_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_sienna),context.getString(R.string.kia_sienna_s),context.getString(R.string.kia_sienna_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_shuma),context.getString(R.string.kia_shuma_s),context.getString(R.string.kia_shuma_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_forte),context.getString(R.string.kia_forte_s),context.getString(R.string.kia_forte_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_venga),context.getString(R.string.kia_venga_s),context.getString(R.string.kia_venga_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_captital),context.getString(R.string.kia_captital_s),context.getString(R.string.kia_captital_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_cadenza),context.getString(R.string.kia_cadenza_s),context.getString(R.string.kia_cadenza_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_carens),context.getString(R.string.kia_carens_s),context.getString(R.string.kia_carens_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_carnival),context.getString(R.string.kia_carnival_s),context.getString(R.string.kia_carnival_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_clarus),context.getString(R.string.kia_clarus_s),context.getString(R.string.kia_clarus_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_quoris),context.getString(R.string.kia_quoris_s),context.getString(R.string.kia_quoris_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_cosmos),context.getString(R.string.kia_cosmos_s),context.getString(R.string.kia_cosmos_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_concorde),context.getString(R.string.kia_concorde_s),context.getString(R.string.kia_concorde_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_magnetis),context.getString(R.string.kia_magnetis_s),context.getString(R.string.kia_magnetis_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_mohave),context.getString(R.string.kia_mohave_s),context.getString(R.string.kia_mohave_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_niro),context.getString(R.string.kia_niro_s),context.getString(R.string.kia_niro_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_ray),context.getString(R.string.kia_ray_s),context.getString(R.string.kia_ray_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_telluride),context.getString(R.string.kia_telluride_s),context.getString(R.string.kia_telluride_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_stinger),context.getString(R.string.kia_stinger_s),context.getString(R.string.kia_stinger_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_creed),context.getString(R.string.kia_creed_s),context.getString(R.string.kia_creed_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_stonic),context.getString(R.string.kia_stonic_s),context.getString(R.string.kia_stonic_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_sedona),context.getString(R.string.kia_sedona_s),context.getString(R.string.kia_sedona_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_lotze),context.getString(R.string.kia_lotze_s),context.getString(R.string.kia_lotze_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.kia_pegas),context.getString(R.string.kia_pegas_s),context.getString(R.string.kia_pegas_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarBMWArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_116),context.getString(R.string.bmw_116_s),context.getString(R.string.bmw_116_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_118),context.getString(R.string.bmw_118_s),context.getString(R.string.bmw_118_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_120),context.getString(R.string.bmw_120_s),context.getString(R.string.bmw_120_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_125),context.getString(R.string.bmw_125_s),context.getString(R.string.bmw_125_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_135),context.getString(R.string.bmw_135_s),context.getString(R.string.bmw_135_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_225),context.getString(R.string.bmw_225_s),context.getString(R.string.bmw_225_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_),context.getString(R.string.bmw__s),context.getString(R.string.bmw__ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_2002),context.getString(R.string.bmw_2002_s),context.getString(R.string.bmw_2002_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_316),context.getString(R.string.bmw_316_s),context.getString(R.string.bmw_316_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_318),context.getString(R.string.bmw_318_s),context.getString(R.string.bmw_318_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_320),context.getString(R.string.bmw_320_s),context.getString(R.string.bmw_320_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_323),context.getString(R.string.bmw_323_s),context.getString(R.string.bmw_323_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_325),context.getString(R.string.bmw_325_s),context.getString(R.string.bmw_325_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_328),context.getString(R.string.bmw_328_s),context.getString(R.string.bmw_328_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_330),context.getString(R.string.bmw_330_s),context.getString(R.string.bmw_330_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_335),context.getString(R.string.bmw_335_s),context.getString(R.string.bmw_335_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_e30),context.getString(R.string.bmw_e30_s),context.getString(R.string.bmw_e30_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_328_gran_turismo),context.getString(R.string.bmw_328_gran_turismo_s),context.getString(R.string.bmw_328_gran_turismo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_gt),context.getString(R.string.bmw_gt_s),context.getString(R.string.bmw_gt_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_420),context.getString(R.string.bmw_420_s),context.getString(R.string.bmw_420_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_428),context.getString(R.string.bmw_428_s),context.getString(R.string.bmw_428_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_435),context.getString(R.string.bmw_435_s),context.getString(R.string.bmw_435_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_520),context.getString(R.string.bmw_520_s),context.getString(R.string.bmw_520_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_523),context.getString(R.string.bmw_523_s),context.getString(R.string.bmw_523_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_525),context.getString(R.string.bmw_525_s),context.getString(R.string.bmw_525_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_528),context.getString(R.string.bmw_528_s),context.getString(R.string.bmw_528_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_530),context.getString(R.string.bmw_530_s),context.getString(R.string.bmw_530_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_535),context.getString(R.string.bmw_535_s),context.getString(R.string.bmw_535_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_540),context.getString(R.string.bmw_540_s),context.getString(R.string.bmw_540_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_545),context.getString(R.string.bmw_545_s),context.getString(R.string.bmw_545_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_550),context.getString(R.string.bmw_550_s),context.getString(R.string.bmw_550_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_e39),context.getString(R.string.bmw_e39_s),context.getString(R.string.bmw_e39_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_535gran_turismo),context.getString(R.string.bmw_535gran_turismo_s),context.getString(R.string.bmw_535gran_turismo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_630),context.getString(R.string.bmw_630_s),context.getString(R.string.bmw_630_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_640),context.getString(R.string.bmw_640_s),context.getString(R.string.bmw_640_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_645),context.getString(R.string.bmw_645_s),context.getString(R.string.bmw_645_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_650),context.getString(R.string.bmw_650_s),context.getString(R.string.bmw_650_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_760),context.getString(R.string.bmw_760_s),context.getString(R.string.bmw_760_ar)));
//        //carModelArrayList.add(new CarModel(context.getString(R.string.audi_a),context.getString(R.string.bmw_760_s)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_730),context.getString(R.string.bmw_730_s),context.getString(R.string.bmw_730_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_735),context.getString(R.string.bmw_735_s),context.getString(R.string.bmw_735_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_740),context.getString(R.string.bmw_740_s),context.getString(R.string.bmw_740_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_745),context.getString(R.string.bmw_745_s),context.getString(R.string.bmw_745_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_750),context.getString(R.string.audi_a_s),context.getString(R.string.audi_a_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_i3),context.getString(R.string.bmw_i3_s),context.getString(R.string.bmw_i3_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_i8),context.getString(R.string.bmw_i8_s),context.getString(R.string.bmw_i8_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_m2),context.getString(R.string.bmw_m2_s),context.getString(R.string.bmw_m2_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_m3),context.getString(R.string.bmw_m3_s),context.getString(R.string.bmw_m3_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_m5),context.getString(R.string.bmw_m5_s),context.getString(R.string.bmw_m5_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_m6),context.getString(R.string.bmw_m6_s),context.getString(R.string.bmw_m6_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_m_coupe),context.getString(R.string.bmw_m_coupe_s),context.getString(R.string.bmw_m_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_m4),context.getString(R.string.bmw_m4_s),context.getString(R.string.bmw_m4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_1m),context.getString(R.string.bmw_1m_s),context.getString(R.string.bmw_1m_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_m_roadster),context.getString(R.string.bmw_m_roadster_s),context.getString(R.string.bmw_m_roadster_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_x3),context.getString(R.string.bmw_x3_s),context.getString(R.string.bmw_x3_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_x4),context.getString(R.string.bmw_x4_s),context.getString(R.string.bmw_x4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_x5),context.getString(R.string.bmw_x5_s),context.getString(R.string.bmw_x5_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_x6),context.getString(R.string.bmw_x6_s),context.getString(R.string.bmw_x6_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_x6_m),context.getString(R.string.bmw_x6_m_s),context.getString(R.string.bmw_x6_m_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_x5_m),context.getString(R.string.bmw_x5_m_s),context.getString(R.string.bmw_x5_m_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_x7),context.getString(R.string.bmw_x7_s),context.getString(R.string.bmw_x7_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_z1),context.getString(R.string.bmw_z1_s),context.getString(R.string.bmw_z1_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_z3),context.getString(R.string.bmw_z3_s),context.getString(R.string.bmw_z3_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_z3m),context.getString(R.string.bmw_z3m_s),context.getString(R.string.bmw_z3m_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_z4),context.getString(R.string.bmw_z4_s),context.getString(R.string.bmw_z4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_z4m),context.getString(R.string.bmw_z4m_s),context.getString(R.string.bmw_z4m_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_z8),context.getString(R.string.bmw_z8_s),context.getString(R.string.bmw_z8_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_1502),context.getString(R.string.bmw_1502_s),context.getString(R.string.bmw_1502_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bmw_alpina),context.getString(R.string.bmw_alpina_s),context.getString(R.string.bmw_alpina_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarMercedes_benzArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.Mercedes_benz_gle_400_amg),context.getString(R.string.Mercedes_benz_gle_400_amg_s),context.getString(R.string.Mercedes_benz_gle_400_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gle_450_amg),context.getString(R.string.mercedes_benz_gle_450_amg_s),context.getString(R.string.mercedes_benz_gle_450_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.Mercedes_benz_gle_500),context.getString(R.string.Mercedes_benz_gle_500_s),context.getString(R.string.Mercedes_benz_gle_500_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gle_63_amg),context.getString(R.string.mercedes_benz_gle_63_amg_s),context.getString(R.string.mercedes_benz_gle_63_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gla_class),context.getString(R.string.mercedes_benz_gla_class_s),context.getString(R.string.mercedes_benz_gla_class_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gla_250),context.getString(R.string.mercedes_benz_gla_250_s),context.getString(R.string.mercedes_benz_gla_250_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gla_45),context.getString(R.string.mercedes_benz_gla_45_s),context.getString(R.string.mercedes_benz_gla_45_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_a_class),context.getString(R.string.mercedes_benz_a_class_s),context.getString(R.string.mercedes_benz_a_class_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_a_140),context.getString(R.string.mercedes_benz_a_140_s),context.getString(R.string.mercedes_benz_a_140_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_a_45),context.getString(R.string.mercedes_benz_a_45_s),context.getString(R.string.mercedes_benz_a_45_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_a_160),context.getString(R.string.mercedes_benz_a_160_s),context.getString(R.string.mercedes_benz_a_160_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_a_180),context.getString(R.string.mercedes_benz_a_180_s),context.getString(R.string.mercedes_benz_a_180_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_a_250),context.getString(R.string.mercedes_benz_a_250_s),context.getString(R.string.mercedes_benz_a_250_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_a_45_amg),context.getString(R.string.mercedes_benz_a_45_amg_s),context.getString(R.string.mercedes_benz_a_45_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_b_class),context.getString(R.string.mercedes_benz_b_class_s),context.getString(R.string.mercedes_benz_b_class_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_b200),context.getString(R.string.mercedes_benz_b200_s),context.getString(R.string.mercedes_benz_b200_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_class),context.getString(R.string.mercedes_benz_c_class_s),context.getString(R.string.mercedes_benz_c_class_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c180),context.getString(R.string.mercedes_benz_c180_s),context.getString(R.string.mercedes_benz_c180_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c200),context.getString(R.string.mercedes_benz_c200_s),context.getString(R.string.mercedes_benz_c200_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_220),context.getString(R.string.mercedes_benz_c_220_s),context.getString(R.string.mercedes_benz_c_220_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_230),context.getString(R.string.mercedes_benz_c_230_s),context.getString(R.string.mercedes_benz_c_230_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_240),context.getString(R.string.mercedes_benz_c_240_s),context.getString(R.string.mercedes_benz_c_240_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c250),context.getString(R.string.mercedes_benz_c250_s),context.getString(R.string.mercedes_benz_c250_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_280),context.getString(R.string.mercedes_benz_c_280_s),context.getString(R.string.mercedes_benz_c_280_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_350),context.getString(R.string.mercedes_benz_c_350_s),context.getString(R.string.mercedes_benz_c_350_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c63_amg),context.getString(R.string.mercedes_benz_c63_amg_s),context.getString(R.string.mercedes_benz_c63_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_55),context.getString(R.string.mercedes_benz_c_55_s),context.getString(R.string.mercedes_benz_c_55_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_350e),context.getString(R.string.mercedes_benz_c_350e_s),context.getString(R.string.mercedes_benz_c_350e_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_180_coupe),context.getString(R.string.mercedes_benz_c_180_coupe_s),context.getString(R.string.mercedes_benz_c_180_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_300_coupe),context.getString(R.string.mercedes_benz_c_300_coupe_s),context.getString(R.string.mercedes_benz_c_300_coupe_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_32_amg),context.getString(R.string.mercedes_benz_c_32_amg_s),context.getString(R.string.mercedes_benz_c_32_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_43_amg),context.getString(R.string.mercedes_benz_c_43_amg_s),context.getString(R.string.mercedes_benz_c_43_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_55_amg),context.getString(R.string.mercedes_benz_c_55_amg_s),context.getString(R.string.mercedes_benz_c_55_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_63_amg),context.getString(R.string.mercedes_benz_c_63_amg_s),context.getString(R.string.mercedes_benz_c_63_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_63_coupe),context.getString(R.string.mercedes_benz_c_63_coupe_s),context.getString(R.string.mercedes_benz_c_63_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_200_coupe),context.getString(R.string.mercedes_benz_c_200_coupe_s),context.getString(R.string.mercedes_benz_c_200_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_c_320),context.getString(R.string.mercedes_benz_c_320_s),context.getString(R.string.mercedes_benz_c_320_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cl_300),context.getString(R.string.mercedes_benz_cl_300_s),context.getString(R.string.mercedes_benz_cl_300_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cl_320),context.getString(R.string.mercedes_benz_cl_320_s),context.getString(R.string.mercedes_benz_cl_320_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cl_350),context.getString(R.string.mercedes_benz_cl_350_s),context.getString(R.string.mercedes_benz_cl_350_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cl_500),context.getString(R.string.mercedes_benz_cl_500_s),context.getString(R.string.mercedes_benz_cl_500_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cl_55_amg),context.getString(R.string.mercedes_benz_cl_55_amg_s),context.getString(R.string.mercedes_benz_cl_55_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cl_65_amg),context.getString(R.string.mercedes_benz_cl_65_amg_s),context.getString(R.string.mercedes_benz_cl_65_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cl_550),context.getString(R.string.mercedes_benz_cl_550_s),context.getString(R.string.mercedes_benz_cl_550_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cl_63_amg),context.getString(R.string.mercedes_benz_cl_63_amg_s),context.getString(R.string.mercedes_benz_cl_63_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cl_600),context.getString(R.string.mercedes_benz_cl_600_s),context.getString(R.string.mercedes_benz_cl_600_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cla),context.getString(R.string.mercedes_benz_cla_s),context.getString(R.string.mercedes_benz_cla_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cla_200),context.getString(R.string.mercedes_benz_cla_220_s),context.getString(R.string.mercedes_benz_cla_220_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cla_220),context.getString(R.string.mercedes_benz_cla_220_s),context.getString(R.string.mercedes_benz_cla_220_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cla_45_amg),context.getString(R.string.mercedes_benz_cla_45_amg_s),context.getString(R.string.mercedes_benz_cla_45_amg_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cla_450),context.getString(R.string.mercedes_benz_cla_450_s),context.getString(R.string.mercedes_benz_cla_450_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cla_250),context.getString(R.string.mercedes_benz_cla_250_s),context.getString(R.string.mercedes_benz_cla_250_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_clk),context.getString(R.string.mercedes_benz_clk_s),context.getString(R.string.mercedes_benz_clk_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_clk_200),context.getString(R.string.mercedes_benz_clk_200_s),context.getString(R.string.mercedes_benz_clk_200_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_clk_240),context.getString(R.string.mercedes_benz_clk_240_s),context.getString(R.string.mercedes_benz_clk_240_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_clk_350),context.getString(R.string.mercedes_benz_clk_350_s),context.getString(R.string.mercedes_benz_clk_350_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_clk_55_amg),context.getString(R.string.mercedes_benz_clk_55_amg_s),context.getString(R.string.mercedes_benz_clk_55_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_clk_63_amg),context.getString(R.string.mercedes_benz_clk_63_amg_s),context.getString(R.string.mercedes_benz_clk_63_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_clk_320),context.getString(R.string.mercedes_benz_clk_320_s),context.getString(R.string.mercedes_benz_clk_320_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cls),context.getString(R.string.mercedes_benz_cls_s),context.getString(R.string.mercedes_benz_cls_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cls_350),context.getString(R.string.mercedes_benz_cls_350_s),context.getString(R.string.mercedes_benz_cls_350_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cls_400),context.getString(R.string.mercedes_benz_cls_400_s),context.getString(R.string.mercedes_benz_cls_400_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cls_500),context.getString(R.string.mercedes_benz_cls_500_s),context.getString(R.string.mercedes_benz_cls_500_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cls_55_amg),context.getString(R.string.mercedes_benz_cls_55_amg_s),context.getString(R.string.mercedes_benz_cls_55_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cls_63_amg),context.getString(R.string.mercedes_benz_cls_63_amg_s),context.getString(R.string.mercedes_benz_cls_63_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_cls_550),context.getString(R.string.mercedes_benz_cls_550_s),context.getString(R.string.mercedes_benz_cls_550_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e190),context.getString(R.string.mercedes_benz_e190_s),context.getString(R.string.mercedes_benz_e190_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e200),context.getString(R.string.mercedes_benz_e200_s),context.getString(R.string.mercedes_benz_e200_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e230),context.getString(R.string.mercedes_benz_e230_s),context.getString(R.string.mercedes_benz_e230_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e240),context.getString(R.string.mercedes_benz_e240_s),context.getString(R.string.mercedes_benz_e240_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e250),context.getString(R.string.mercedes_benz_e250_s),context.getString(R.string.mercedes_benz_e250_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e280),context.getString(R.string.mercedes_benz_e280_s),context.getString(R.string.mercedes_benz_e280_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e300),context.getString(R.string.mercedes_benz_e300_s),context.getString(R.string.mercedes_benz_e300_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e320),context.getString(R.string.mercedes_benz_e320_s),context.getString(R.string.mercedes_benz_e320_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e350),context.getString(R.string.mercedes_benz_e350_s),context.getString(R.string.mercedes_benz_e350_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e400),context.getString(R.string.mercedes_benz_e400_s),context.getString(R.string.mercedes_benz_e400_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e500),context.getString(R.string.mercedes_benz_e500_s),context.getString(R.string.mercedes_benz_e500_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e55_amg),context.getString(R.string.mercedes_benz_e55_amg_s),context.getString(R.string.mercedes_benz_e55_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e550),context.getString(R.string.mercedes_benz_e550_s),context.getString(R.string.mercedes_benz_e550_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e63_amg),context.getString(R.string.mercedes_benz_e63_amg_s),context.getString(R.string.mercedes_benz_e63_amg_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e63),context.getString(R.string.mercedes_benz_e63_s),context.getString(R.string.mercedes_benz_e63_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e350e),context.getString(R.string.mercedes_benz_e350e_s),context.getString(R.string.mercedes_benz_e350e_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e400_coupe),context.getString(R.string.mercedes_benz_e400_coupe_s),context.getString(R.string.mercedes_benz_e400_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e430),context.getString(R.string.mercedes_benz_e430_s),context.getString(R.string.mercedes_benz_e430_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e50),context.getString(R.string.mercedes_benz_e50_s),context.getString(R.string.mercedes_benz_e50_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e60_amg),context.getString(R.string.mercedes_benz_e60_amg_s),context.getString(R.string.mercedes_benz_e60_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_e250_coupe),context.getString(R.string.mercedes_benz_e250_coupe_s),context.getString(R.string.mercedes_benz_e250_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_g_300),context.getString(R.string.mercedes_benz_g_300_s),context.getString(R.string.mercedes_benz_g_300_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_g_500),context.getString(R.string.mercedes_benz_g_500_s),context.getString(R.string.mercedes_benz_g_500_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_g_55),context.getString(R.string.mercedes_benz_g_55_s),context.getString(R.string.mercedes_benz_g_55_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_g_320),context.getString(R.string.mercedes_benz_g_320_s),context.getString(R.string.mercedes_benz_g_320_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_g_36_amg),context.getString(R.string.mercedes_benz_g_36_amg_s),context.getString(R.string.mercedes_benz_g_36_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_g_500_4x42),context.getString(R.string.mercedes_benz_g_500_4x42_s),context.getString(R.string.mercedes_benz_g_500_4x42_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_g_55_amg),context.getString(R.string.mercedes_benz_g_55_amg_s),context.getString(R.string.mercedes_benz_g_55_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_g_550),context.getString(R.string.mercedes_benz_g_550_s),context.getString(R.string.mercedes_benz_g_550_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_g_63_amg_6x6),context.getString(R.string.mercedes_benz_g_63_amg_6x6_s),context.getString(R.string.mercedes_benz_g_63_amg_6x6_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_g_65_amg),context.getString(R.string.mercedes_benz_g_65_amg_s),context.getString(R.string.mercedes_benz_g_65_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_g_63_amg),context.getString(R.string.mercedes_benz_g_63_amg),context.getString(R.string.mercedes_benz_g_63_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gl_320),context.getString(R.string.mercedes_benz_gl_320_s),context.getString(R.string.mercedes_benz_gl_320_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gl_450),context.getString(R.string.mercedes_benz_gl_450_s),context.getString(R.string.mercedes_benz_gl_450_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gl_500),context.getString(R.string.mercedes_benz_gl_500_s),context.getString(R.string.mercedes_benz_gl_500_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gl_550),context.getString(R.string.mercedes_benz_gl_550_s),context.getString(R.string.mercedes_benz_gl_550_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gl_63_amg),context.getString(R.string.mercedes_benz_gl_63_amg_s),context.getString(R.string.mercedes_benz_gl_63_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gl),context.getString(R.string.mercedes_benz_gl_s),context.getString(R.string.mercedes_benz_gl_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gls),context.getString(R.string.mercedes_benz_gls_s),context.getString(R.string.mercedes_benz_gls_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gla),context.getString(R.string.mercedes_benz_gla_s),context.getString(R.string.mercedes_benz_gla_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_glk_250),context.getString(R.string.mercedes_benz_glk_250_s),context.getString(R.string.mercedes_benz_glk_250_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_glk_300),context.getString(R.string.mercedes_benz_glk_300_s),context.getString(R.string.mercedes_benz_glk_300_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_glk_350),context.getString(R.string.mercedes_benz_glk_350_s),context.getString(R.string.mercedes_benz_glk_350_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_glk),context.getString(R.string.mercedes_benz_glk_s),context.getString(R.string.mercedes_benz_glk_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_glc),context.getString(R.string.mercedes_benz_glc_s),context.getString(R.string.mercedes_benz_glc_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_glc_250_coupe),context.getString(R.string.mercedes_benz_glc_250_coupe_s),context.getString(R.string.mercedes_benz_glc_250_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_glc_350e_coupe),context.getString(R.string.mercedes_benz_glc_350e_coupe_s),context.getString(R.string.mercedes_benz_glc_350e_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_glc_250),context.getString(R.string.mercedes_benz_glc_250_s),context.getString(R.string.mercedes_benz_glc_250_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_glc_300),context.getString(R.string.mercedes_benz_glc_300_s),context.getString(R.string.mercedes_benz_glc_300_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_glc_350e),context.getString(R.string.mercedes_benz_glc_350e_s),context.getString(R.string.mercedes_benz_glc_350e_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gle_500e),context.getString(R.string.mercedes_benz_gle_500e_s),context.getString(R.string.mercedes_benz_gle_500e_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gle_400),context.getString(R.string.mercedes_benz_gle_400_s),context.getString(R.string.mercedes_benz_gle_400_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_ml_250),context.getString(R.string.mercedes_benz_ml_250_s),context.getString(R.string.mercedes_benz_ml_250_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_ml_320),context.getString(R.string.mercedes_benz_ml_320_s),context.getString(R.string.mercedes_benz_ml_320_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_ml_350),context.getString(R.string.mercedes_benz_ml_350_s),context.getString(R.string.mercedes_benz_ml_350_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_ml_400),context.getString(R.string.mercedes_benz_ml_400_s),context.getString(R.string.mercedes_benz_ml_400_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_ml_500),context.getString(R.string.mercedes_benz_ml_500_s),context.getString(R.string.mercedes_benz_ml_500_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_ml_63_amg),context.getString(R.string.mercedes_benz_ml_63_amg_s),context.getString(R.string.mercedes_benz_ml_63_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gle),context.getString(R.string.mercedes_benz_gle_s),context.getString(R.string.mercedes_benz_gle_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gle_400_coupe),context.getString(R.string.mercedes_benz_gle_400_coupe_s),context.getString(R.string.mercedes_benz_gle_400_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_ml),context.getString(R.string.mercedes_benz_ml_s),context.getString(R.string.mercedes_benz_ml_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_280),context.getString(R.string.mercedes_benz_s_280_s),context.getString(R.string.mercedes_benz_s_280_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_300),context.getString(R.string.mercedes_benz_s_300_s),context.getString(R.string.mercedes_benz_s_300_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_320),context.getString(R.string.mercedes_benz_s_320_s),context.getString(R.string.mercedes_benz_s_320_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_400),context.getString(R.string.mercedes_benz_s_400_s),context.getString(R.string.mercedes_benz_s_400_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_500),context.getString(R.string.mercedes_benz_s_500_s),context.getString(R.string.mercedes_benz_s_500_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_350),context.getString(R.string.mercedes_benz_s_350_s),context.getString(R.string.mercedes_benz_s_350_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_55_amg),context.getString(R.string.mercedes_benz_s_55_amg_s),context.getString(R.string.mercedes_benz_s_55_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_400_coupe),context.getString(R.string.mercedes_benz_s_400_coupe_s),context.getString(R.string.mercedes_benz_s_400_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_430),context.getString(R.string.mercedes_benz_s_430_s),context.getString(R.string.mercedes_benz_s_430_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_500_coupe),context.getString(R.string.mercedes_benz_s_500_coupe_s),context.getString(R.string.mercedes_benz_s_500_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_55),context.getString(R.string.mercedes_benz_s_55_s),context.getString(R.string.mercedes_benz_s_55_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_550_Coupe),context.getString(R.string.mercedes_benz_s_550_Coupe_s),context.getString(R.string.mercedes_benz_s_550_Coupe_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_63_amg),context.getString(R.string.mercedes_benz_s_63_amg_s),context.getString(R.string.mercedes_benz_s_63_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_63_amg_coupe),context.getString(R.string.mercedes_benz_s_63_amg_coupe_s),context.getString(R.string.mercedes_benz_s_63_amg_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_65_amg),context.getString(R.string.mercedes_benz_s_65_amg_s),context.getString(R.string.mercedes_benz_s_65_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_550),context.getString(R.string.mercedes_benz_s_550_s),context.getString(R.string.mercedes_benz_s_550_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_s_600),context.getString(R.string.mercedes_benz_s_600_s),context.getString(R.string.mercedes_benz_s_600_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_maybach),context.getString(R.string.mercedes_maybach_s),context.getString(R.string.mercedes_maybach_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_300_se),context.getString(R.string.mercedes_benz_300_se_s),context.getString(R.string.mercedes_benz_300_se_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_sl),context.getString(R.string.mercedes_benz_sl_s),context.getString(R.string.mercedes_benz_sl_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_sl_320),context.getString(R.string.mercedes_benz_sl_320_s),context.getString(R.string.mercedes_benz_sl_320_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_sl_350),context.getString(R.string.mercedes_benz_sl_350_s),context.getString(R.string.mercedes_benz_sl_350_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_sl_400),context.getString(R.string.mercedes_benz_sl_400_s),context.getString(R.string.mercedes_benz_sl_400_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_sl_500),context.getString(R.string.mercedes_benz_sl_500_s),context.getString(R.string.mercedes_benz_sl_500_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_sl_55_amg),context.getString(R.string.mercedes_benz_sl_55_amg_s),context.getString(R.string.mercedes_benz_sl_55_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_sl_550),context.getString(R.string.mercedes_benz_sl_550_s),context.getString(R.string.mercedes_benz_sl_550_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_sl_560),context.getString(R.string.mercedes_benz_sl_560_s),context.getString(R.string.mercedes_benz_sl_560_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_sl_63_amg),context.getString(R.string.mercedes_benz_sl_63_amg_s),context.getString(R.string.mercedes_benz_sl_63_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_sl_65_amg),context.getString(R.string.mercedes_benz_sl_65_amg_s),context.getString(R.string.mercedes_benz_sl_65_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_slc),context.getString(R.string.mercedes_benz_slc_s),context.getString(R.string.mercedes_benz_slc_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_slc_200),context.getString(R.string.mercedes_benz_slc_200_s),context.getString(R.string.mercedes_benz_slc_200_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_slk),context.getString(R.string.mercedes_benz_slk_s),context.getString(R.string.mercedes_benz_slk_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_slk_200),context.getString(R.string.mercedes_benz_slk_200_s),context.getString(R.string.mercedes_benz_slk_200_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_slk_230),context.getString(R.string.mercedes_benz_slk_230_s),context.getString(R.string.mercedes_benz_slk_230_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_slk_250),context.getString(R.string.mercedes_benz_slk_250_s),context.getString(R.string.mercedes_benz_slk_250_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_slk_280),context.getString(R.string.mercedes_benz_slk_280_s),context.getString(R.string.mercedes_benz_slk_280_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_slk_320),context.getString(R.string.mercedes_benz_slk_320_s),context.getString(R.string.mercedes_benz_slk_320_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_slk_350),context.getString(R.string.mercedes_benz_slk_350_s),context.getString(R.string.mercedes_benz_slk_350_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_slk_55_amg),context.getString(R.string.mercedes_benz_slk_55_amg_s),context.getString(R.string.mercedes_benz_slk_55_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_slk_63_amg),context.getString(R.string.mercedes_benz_slk_63_amg_s),context.getString(R.string.mercedes_benz_slk_63_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_v_class),context.getString(R.string.mercedes_benz_v_class_s),context.getString(R.string.mercedes_benz_v_class_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_vito_119),context.getString(R.string.mercedes_benz_vito_119_s),context.getString(R.string.mercedes_benz_vito_119_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_vito_109),context.getString(R.string.mercedes_benz_vito_109_s),context.getString(R.string.mercedes_benz_vito_109_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_vito_111),context.getString(R.string.mercedes_benz_vito_111_s),context.getString(R.string.mercedes_benz_vito_111_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_vito_114),context.getString(R.string.mercedes_benz_vito_114_s),context.getString(R.string.mercedes_benz_vito_114_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_vito_116),context.getString(R.string.mercedes_benz_vito_116_s),context.getString(R.string.mercedes_benz_vito_116_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_v_250),context.getString(R.string.mercedes_benz_v_250_s),context.getString(R.string.mercedes_benz_v_250_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_v_220),context.getString(R.string.mercedes_benz_v_220_s),context.getString(R.string.mercedes_benz_v_220_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_r_class),context.getString(R.string.mercedes_benz_r_class_s),context.getString(R.string.mercedes_benz_r_class_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_r_280),context.getString(R.string.mercedes_benz_r_280_s),context.getString(R.string.mercedes_benz_r_280_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_r_300),context.getString(R.string.mercedes_benz_r_300_s),context.getString(R.string.mercedes_benz_r_300_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_r_320),context.getString(R.string.mercedes_benz_r_320_s),context.getString(R.string.mercedes_benz_r_320_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_r_350),context.getString(R.string.mercedes_benz_r_350_s),context.getString(R.string.mercedes_benz_r_350_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_r_500),context.getString(R.string.mercedes_benz_r_500_s),context.getString(R.string.mercedes_benz_r_500_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_r_550),context.getString(R.string.mercedes_benz_r_550_s),context.getString(R.string.mercedes_benz_r_550_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_r_63),context.getString(R.string.mercedes_benz_r_63_s),context.getString(R.string.mercedes_benz_r_63_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_x_220d),context.getString(R.string.mercedes_benz_x_220d_s),context.getString(R.string.mercedes_benz_x_220d_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_x_250d),context.getString(R.string.mercedes_benz_x_250d_s),context.getString(R.string.mercedes_benz_x_250d_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_x_350d),context.getString(R.string.mercedes_benz_x_350d_s),context.getString(R.string.mercedes_benz_x_350d_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_amg_gt),context.getString(R.string.mercedes_benz_amg_gt_s),context.getString(R.string.mercedes_benz_amg_gt_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_sprinter),context.getString(R.string.mercedes_benz_sprinter_s),context.getString(R.string.mercedes_benz_sprinter_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_smart),context.getString(R.string.mercedes_benz_smart_s),context.getString(R.string.mercedes_benz_smart_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_vito),context.getString(R.string.mercedes_benz_vito_s),context.getString(R.string.mercedes_benz_vito_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_eqc),context.getString(R.string.mercedes_benz_eqc_s),context.getString(R.string.mercedes_benz_eqc_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_190),context.getString(R.string.mercedes_benz_190_s),context.getString(R.string.mercedes_benz_190_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_200),context.getString(R.string.mercedes_benz_200_s),context.getString(R.string.mercedes_benz_200_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_230),context.getString(R.string.mercedes_benz_230_s),context.getString(R.string.mercedes_benz_230_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_250),context.getString(R.string.mercedes_benz_250_s),context.getString(R.string.mercedes_benz_250_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_280),context.getString(R.string.mercedes_benz_280_s),context.getString(R.string.mercedes_benz_280_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_300),context.getString(R.string.mercedes_benz_300_s),context.getString(R.string.mercedes_benz_300_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_320),context.getString(R.string.mercedes_benz_320_s),context.getString(R.string.mercedes_benz_320_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_380),context.getString(R.string.mercedes_benz_380_s),context.getString(R.string.mercedes_benz_380_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_450),context.getString(R.string.mercedes_benz_450_s),context.getString(R.string.mercedes_benz_450_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_500),context.getString(R.string.mercedes_benz_500_s),context.getString(R.string.mercedes_benz_500_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_560),context.getString(R.string.mercedes_benz_560_s),context.getString(R.string.mercedes_benz_560_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_actros),context.getString(R.string.mercedes_benz_actros_s),context.getString(R.string.mercedes_benz_actros_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_axor),context.getString(R.string.mercedes_benz_axor_s),context.getString(R.string.mercedes_benz_axor_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_gazelle),context.getString(R.string.mercedes_benz_gazelle_s),context.getString(R.string.mercedes_benz_gazelle_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_slr),context.getString(R.string.mercedes_benz_slr_s),context.getString(R.string.mercedes_benz_slr_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_sls_amg),context.getString(R.string.mercedes_benz_sls_amg_s),context.getString(R.string.mercedes_benz_sls_amg_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_viano),context.getString(R.string.mercedes_benz_viano_s),context.getString(R.string.mercedes_benz_viano_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.mercedes_benz_other),context.getString(R.string.mercedes_benz_other_s),context.getString(R.string.mercedes_benz_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarAudiArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_a),context.getString(R.string.audi_a_s),context.getString(R.string.audi_a_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_a1),context.getString(R.string.audi_a1_s),context.getString(R.string.audi_a1_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_a2),context.getString(R.string.audi_a2_s),context.getString(R.string.audi_a2_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_a3),context.getString(R.string.audi_a3_s),context.getString(R.string.audi_a3_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_a4),context.getString(R.string.audi_a4_s),context.getString(R.string.audi_a4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_a5),context.getString(R.string.audi_a5_s),context.getString(R.string.audi_a5_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_a6),context.getString(R.string.audi_a6_s),context.getString(R.string.audi_a6_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_a7),context.getString(R.string.audi_a7_s),context.getString(R.string.audi_a7_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_a8),context.getString(R.string.audi_a8_s),context.getString(R.string.audi_a8_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_a9),context.getString(R.string.audi_a9_s),context.getString(R.string.audi_a9_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_q),context.getString(R.string.audi_q_s),context.getString(R.string.audi_q_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_q3),context.getString(R.string.audi_q3_s),context.getString(R.string.audi_q3_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_q5),context.getString(R.string.audi_q5_s),context.getString(R.string.audi_q5_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_q7),context.getString(R.string.audi_q7_s),context.getString(R.string.audi_q7_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_r),context.getString(R.string.audi_r_s),context.getString(R.string.audi_r_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_r8),context.getString(R.string.audi_r8_s),context.getString(R.string.audi_r8_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_rs1),context.getString(R.string.audi_rs1_s),context.getString(R.string.audi_rs1_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_rs2),context.getString(R.string.audi_rs2_s),context.getString(R.string.audi_rs2_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_rs3),context.getString(R.string.audi_rs3_s),context.getString(R.string.audi_rs3_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_rs4),context.getString(R.string.audi_rs4_s),context.getString(R.string.audi_rs4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_rs5),context.getString(R.string.audi_rs5_s),context.getString(R.string.audi_rs5_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_rs6),context.getString(R.string.audi_rs6_s),context.getString(R.string.audi_rs6_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_s_),context.getString(R.string.audi_s__s),context.getString(R.string.audi_s__ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_s1),context.getString(R.string.audi_s1_s),context.getString(R.string.audi_s1_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_s3),context.getString(R.string.audi_s3_s),context.getString(R.string.audi_s3_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_s4),context.getString(R.string.audi_s4_s),context.getString(R.string.audi_s4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_s5),context.getString(R.string.audi_s5_s),context.getString(R.string.audi_s5_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_s6),context.getString(R.string.audi_s6_s),context.getString(R.string.audi_s6_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_s7),context.getString(R.string.audi_s7_s),context.getString(R.string.audi_s7_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_s8),context.getString(R.string.audi_s8_s),context.getString(R.string.audi_s8_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_50),context.getString(R.string.audi_50_s),context.getString(R.string.audi_50_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_60),context.getString(R.string.audi_60_s),context.getString(R.string.audi_60_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_80),context.getString(R.string.audi_80_s),context.getString(R.string.audi_80_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_90),context.getString(R.string.audi_90_s),context.getString(R.string.audi_90_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_100),context.getString(R.string.audi_100_s),context.getString(R.string.audi_100_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_200),context.getString(R.string.audi_200_s),context.getString(R.string.audi_200_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_tt),context.getString(R.string.audi_tt_s),context.getString(R.string.audi_tt_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_v8),context.getString(R.string.audi_v8_s),context.getString(R.string.audi_v8_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_cabriolet),context.getString(R.string.audi_cabriolet_s),context.getString(R.string.audi_cabriolet_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_quattro),context.getString(R.string.audi_quattro_s),context.getString(R.string.audi_quattro_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_coupe),context.getString(R.string.audi_coupe_s),context.getString(R.string.audi_coupe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_e_tron),context.getString(R.string.audi_e_tron_s),context.getString(R.string.audi_e_tron_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_tt_rs),context.getString(R.string.audi_tt_rs_s),context.getString(R.string.audi_tt_rs_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_tts),context.getString(R.string.audi_tts_s),context.getString(R.string.audi_tts_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.audi_other),context.getString(R.string.audi_other_s),context.getString(R.string.audi_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCariSuzuArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_fsr),context.getString(R.string.isuzu_fsr_s),context.getString(R.string.isuzu_fsr_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_nkr),context.getString(R.string.isuzu_nkr_s),context.getString(R.string.isuzu_nkr_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_i_mark),context.getString(R.string.isuzu_i_mark_s),context.getString(R.string.isuzu_i_mark_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_aska),context.getString(R.string.isuzu_aska_s),context.getString(R.string.isuzu_aska_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_amigo),context.getString(R.string.isuzu_amigo_s),context.getString(R.string.isuzu_amigo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_impulse),context.getString(R.string.isuzu_impulse_s),context.getString(R.string.isuzu_impulse_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_ascender),context.getString(R.string.isuzu_ascender_s),context.getString(R.string.isuzu_ascender_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_axiom),context.getString(R.string.isuzu_axiom_s),context.getString(R.string.isuzu_axiom_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_piazza),context.getString(R.string.isuzu_piazza_s),context.getString(R.string.isuzu_piazza_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_bighorn),context.getString(R.string.isuzu_bighorn_s),context.getString(R.string.isuzu_bighorn_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_trooper),context.getString(R.string.isuzu_trooper_s),context.getString(R.string.isuzu_trooper_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_giga),context.getString(R.string.isuzu_giga_s),context.getString(R.string.isuzu_giga_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_d_max),context.getString(R.string.isuzu_d_max_s),context.getString(R.string.isuzu_d_max_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_rodeo),context.getString(R.string.isuzu_rodeo_s),context.getString(R.string.isuzu_rodeo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_fster),context.getString(R.string.isuzu_fster_s),context.getString(R.string.isuzu_fster_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_filly),context.getString(R.string.isuzu_filly_s),context.getString(R.string.isuzu_filly_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_vehicross),context.getString(R.string.isuzu_vehicross_s),context.getString(R.string.isuzu_vehicross_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_wizard),context.getString(R.string.isuzu_wizard_s),context.getString(R.string.isuzu_wizard_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_elf),context.getString(R.string.isuzu_elf_s),context.getString(R.string.isuzu_elf_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_forward),context.getString(R.string.isuzu_forward_s),context.getString(R.string.isuzu_forward_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_juston),context.getString(R.string.isuzu_juston_s),context.getString(R.string.isuzu_juston_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_pickup),context.getString(R.string.isuzu_pickup_s),context.getString(R.string.isuzu_pickup_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_reward),context.getString(R.string.isuzu_reward_s),context.getString(R.string.isuzu_reward_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_v430),context.getString(R.string.isuzu_v430_s),context.getString(R.string.isuzu_v430_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.isuzu_other),context.getString(R.string.isuzu_other_s),context.getString(R.string.isuzu_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarInfinitiArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_e),context.getString(R.string.infiniti_e_s),context.getString(R.string.infiniti_e_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_e30),context.getString(R.string.infiniti_e30_s),context.getString(R.string.infiniti_e30_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_e35),context.getString(R.string.infiniti_e35_s),context.getString(R.string.infiniti_e35_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_ex),context.getString(R.string.infiniti_ex_s),context.getString(R.string.infiniti_ex_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_ex25),context.getString(R.string.infiniti_ex25_s),context.getString(R.string.infiniti_ex25_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_ex35),context.getString(R.string.infiniti_ex35_s),context.getString(R.string.infiniti_ex35_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_ex37),context.getString(R.string.audi_a_s),context.getString(R.string.audi_a_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_FX),context.getString(R.string.infiniti_FX_s),context.getString(R.string.infiniti_FX_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_fx37),context.getString(R.string.infiniti_fx37_s),context.getString(R.string.infiniti_fx37_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_fx45),context.getString(R.string.infiniti_fx45_s),context.getString(R.string.infiniti_fx45_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_fx50),context.getString(R.string.infiniti_fx50_s),context.getString(R.string.infiniti_fx50_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_fx56),context.getString(R.string.infiniti_fx56_s),context.getString(R.string.infiniti_fx56_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_fx35),context.getString(R.string.infiniti_fx35_s),context.getString(R.string.infiniti_fx35_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_G),context.getString(R.string.infiniti_G_s),context.getString(R.string.infiniti_G_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_g20),context.getString(R.string.infiniti_g20_s),context.getString(R.string.infiniti_g20_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_g25),context.getString(R.string.infiniti_g25_s),context.getString(R.string.infiniti_g25_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_g35),context.getString(R.string.infiniti_g35_s),context.getString(R.string.infiniti_g35_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_g37),context.getString(R.string.infiniti_g37_s),context.getString(R.string.infiniti_g37_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_J),context.getString(R.string.infiniti_J_s),context.getString(R.string.infiniti_J_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_j30),context.getString(R.string.infiniti_j30_s),context.getString(R.string.infiniti_j30_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_M),context.getString(R.string.infiniti_M_s),context.getString(R.string.infiniti_M_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_m25),context.getString(R.string.infiniti_m25_s),context.getString(R.string.infiniti_m25_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_m35),context.getString(R.string.infiniti_m35_s),context.getString(R.string.infiniti_m35_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_m37),context.getString(R.string.infiniti_m37_s),context.getString(R.string.infiniti_m37_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_m45),context.getString(R.string.infiniti_m45_s),context.getString(R.string.infiniti_m45_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_m56),context.getString(R.string.infiniti_m56_s),context.getString(R.string.infiniti_m56_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_Q),context.getString(R.string.infiniti_Q_s),context.getString(R.string.infiniti_Q_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_q45),context.getString(R.string.infiniti_q45_s),context.getString(R.string.infiniti_q45_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_qx4),context.getString(R.string.infiniti_qx4_s),context.getString(R.string.infiniti_qx4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_qx56),context.getString(R.string.infiniti_qx56_s),context.getString(R.string.infiniti_qx56_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_q60),context.getString(R.string.infiniti_q60_s),context.getString(R.string.infiniti_q60_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_q70),context.getString(R.string.infiniti_q70_s),context.getString(R.string.infiniti_q70_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_qx60),context.getString(R.string.infiniti_qx60_s),context.getString(R.string.infiniti_qx60_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_q30),context.getString(R.string.infiniti_q30_s),context.getString(R.string.infiniti_q30_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_q50),context.getString(R.string.infiniti_q50_s),context.getString(R.string.infiniti_q50_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_qx80),context.getString(R.string.infiniti_qx80_s),context.getString(R.string.infiniti_qx80_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_I30),context.getString(R.string.infiniti_I30_s),context.getString(R.string.infiniti_I30_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_jx35),context.getString(R.string.infiniti_jx35_s),context.getString(R.string.infiniti_jx35_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_q40),context.getString(R.string.infiniti_q40_s),context.getString(R.string.infiniti_q40_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_qx50),context.getString(R.string.infiniti_qx50_s),context.getString(R.string.infiniti_qx50_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_qx70),context.getString(R.string.infiniti_qx70_s),context.getString(R.string.infiniti_qx70_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.infiniti_other),context.getString(R.string.infiniti_other_s),context.getString(R.string.infiniti_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarOpelArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_agila),context.getString(R.string.opel_agila_s),context.getString(R.string.opel_agila_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_astra),context.getString(R.string.opel_astra_s),context.getString(R.string.opel_astra_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_ascona),context.getString(R.string.opel_ascona_s),context.getString(R.string.opel_ascona_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_admiral),context.getString(R.string.opel_admiral_s),context.getString(R.string.opel_admiral_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_omega),context.getString(R.string.opel_omega_s),context.getString(R.string.opel_omega_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_antara),context.getString(R.string.opel_antara_s),context.getString(R.string.opel_antara_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_insignia),context.getString(R.string.opel_insignia_s),context.getString(R.string.opel_insignia_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_tigra),context.getString(R.string.opel_tigra_s),context.getString(R.string.opel_tigra_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_gt),context.getString(R.string.opel_gt_s),context.getString(R.string.opel_gt_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_diplomat),context.getString(R.string.opel_diplomat_s),context.getString(R.string.opel_diplomat_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_rekord),context.getString(R.string.opel_rekord_s),context.getString(R.string.opel_rekord_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_zafira),context.getString(R.string.opel_zafira_s),context.getString(R.string.opel_zafira_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_speedster),context.getString(R.string.opel_speedster_s),context.getString(R.string.opel_speedster_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_signum),context.getString(R.string.opel_signum_s),context.getString(R.string.opel_signum_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_senator),context.getString(R.string.opel_senator_s),context.getString(R.string.opel_senator_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_sintra),context.getString(R.string.opel_sintra_s),context.getString(R.string.opel_sintra_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_frontera),context.getString(R.string.opel_frontera_s),context.getString(R.string.opel_frontera_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_vita),context.getString(R.string.opel_vita_s),context.getString(R.string.opel_vita_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_vivaro),context.getString(R.string.opel_vivaro_s),context.getString(R.string.opel_vivaro_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_kadett),context.getString(R.string.opel_kadett_s),context.getString(R.string.opel_kadett_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_calibra),context.getString(R.string.opel_calibra_s),context.getString(R.string.opel_calibra_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_campo),context.getString(R.string.opel_campo_s),context.getString(R.string.opel_campo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_corsa),context.getString(R.string.opel_corsa_s),context.getString(R.string.opel_corsa_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_combo),context.getString(R.string.opel_combo_s),context.getString(R.string.opel_combo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_commodore),context.getString(R.string.opel_commodore_s),context.getString(R.string.opel_commodore_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_manta),context.getString(R.string.opel_manta_s),context.getString(R.string.opel_manta_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_movano),context.getString(R.string.opel_movano_s),context.getString(R.string.opel_movano_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_monza),context.getString(R.string.opel_monza_s),context.getString(R.string.opel_monza_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_meriva),context.getString(R.string.opel_meriva_s),context.getString(R.string.opel_meriva_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.opel_other),context.getString(R.string.opel_other_s),context.getString(R.string.opel_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarBentleyArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_turbo_r),context.getString(R.string.bentley_turbo_r_s),context.getString(R.string.bentley_turbo_r_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_arnage),context.getString(R.string.bentley_arnage_s),context.getString(R.string.bentley_arnage_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_azure),context.getString(R.string.bentley_azure_s),context.getString(R.string.bentley_azure_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_brooklands),context.getString(R.string.bentley_brooklands_s),context.getString(R.string.bentley_brooklands_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_flying_spur),context.getString(R.string.bentley_flying_spur_s),context.getString(R.string.bentley_flying_spur_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_continental),context.getString(R.string.bentley_continental_s),context.getString(R.string.bentley_continental_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_continental_gt),context.getString(R.string.bentley_continental_gt_s),context.getString(R.string.bentley_continental_gt_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_mulsanne),context.getString(R.string.bentley_mulsanne_s),context.getString(R.string.bentley_mulsanne_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_bentayga),context.getString(R.string.bentley_bentayga_s),context.getString(R.string.bentley_bentayga_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_continental_gtc),context.getString(R.string.bentley_continental_gtc_s),context.getString(R.string.bentley_continental_gtc_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_continental_supersports),context.getString(R.string.bentley_continental_supersports_s),context.getString(R.string.bentley_continental_supersports_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_turbo_s),context.getString(R.string.bentley_turbo_s_s),context.getString(R.string.bentley_turbo_s_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.bentley_other),context.getString(R.string.bentley_other_s),context.getString(R.string.bentley_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarPorscheArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_9xx),context.getString(R.string.porsche_9xx_s),context.getString(R.string.porsche_9xx_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_911),context.getString(R.string.porsche_911_s),context.getString(R.string.porsche_911_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_924),context.getString(R.string.porsche_924_s),context.getString(R.string.porsche_924_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_928),context.getString(R.string.porsche_928_s),context.getString(R.string.porsche_928_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_944),context.getString(R.string.porsche_944_s),context.getString(R.string.porsche_944_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_959),context.getString(R.string.porsche_959_s),context.getString(R.string.porsche_959_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_968),context.getString(R.string.porsche_968_s),context.getString(R.string.porsche_968_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_911_4),context.getString(R.string.porsche_911_4_s),context.getString(R.string.porsche_911_4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_911_4s),context.getString(R.string.porsche_911_4s_s),context.getString(R.string.porsche_911_4s_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_911_gt2),context.getString(R.string.porsche_911_gt2_s),context.getString(R.string.porsche_911_gt2_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_911_gt_3),context.getString(R.string.porsche_911_gt_3_s),context.getString(R.string.porsche_911_gt_3_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_911_s),context.getString(R.string.porsche_911_s_s),context.getString(R.string.porsche_911_s_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_911_targa),context.getString(R.string.porsche_911_targa_s),context.getString(R.string.porsche_911_targa_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_911_targa_4),context.getString(R.string.porsche_911_targa_4_s),context.getString(R.string.porsche_911_targa_4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_911_turbo),context.getString(R.string.porsche_911_turbo_s),context.getString(R.string.porsche_911_turbo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_911_turbo_s),context.getString(R.string.porsche_911_turbo_s_s),context.getString(R.string.porsche_911_turbo_s_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_918_spyder),context.getString(R.string.porsche_918_spyder_s),context.getString(R.string.porsche_918_spyder_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_993),context.getString(R.string.porsche_993_s),context.getString(R.string.porsche_993_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_996),context.getString(R.string.porsche_996_s),context.getString(R.string.porsche_996_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_panamera),context.getString(R.string.porsche_panamera_s),context.getString(R.string.porsche_panamera_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_boxster),context.getString(R.string.porsche_boxster_s),context.getString(R.string.porsche_boxster_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_carrera_gt),context.getString(R.string.porsche_carrera_gt_s),context.getString(R.string.porsche_carrera_gt_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_cayman),context.getString(R.string.porsche_cayman_s),context.getString(R.string.porsche_cayman_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_cayenne),context.getString(R.string.porsche_cayenne_s),context.getString(R.string.porsche_cayenne_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_cayenne_s),context.getString(R.string.porsche_cayenne_s_s),context.getString(R.string.porsche_cayenne_s_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_cayenne_turbo),context.getString(R.string.porsche_cayenne_turbo_s),context.getString(R.string.porsche_cayenne_turbo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_cayenne_turbo_s),context.getString(R.string.porsche_cayenne_turbo_s_s),context.getString(R.string.porsche_cayenne_turbo_s_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_cayenne_gts),context.getString(R.string.porsche_cayenne_gts_s),context.getString(R.string.porsche_cayenne_gts_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_macan),context.getString(R.string.porsche_macan_s),context.getString(R.string.porsche_macan_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_boxster_gts),context.getString(R.string.porsche_boxster_gts_s),context.getString(R.string.porsche_boxster_gts_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_boxster_s),context.getString(R.string.porsche_boxster_s_s),context.getString(R.string.porsche_boxster_s_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_cayman_s),context.getString(R.string.porsche_cayman_s_s),context.getString(R.string.porsche_cayman_s_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_macan_s),context.getString(R.string.porsche_macan_s_s),context.getString(R.string.porsche_macan_s_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_macan_turbo),context.getString(R.string.porsche_macan_turbo_s),context.getString(R.string.porsche_macan_turbo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_panamera_4),context.getString(R.string.porsche_panamera_4_s),context.getString(R.string.porsche_panamera_4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_Panamera_4s),context.getString(R.string.porsche_Panamera_4s_s),context.getString(R.string.porsche_Panamera_4s_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_panamera_gts),context.getString(R.string.porsche_panamera_gts_s),context.getString(R.string.porsche_panamera_gts_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_panamera_s),context.getString(R.string.porsche_panamera_s_s),context.getString(R.string.porsche_panamera_s_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_panamera_turbo),context.getString(R.string.porsche_panamera_turbo_s),context.getString(R.string.porsche_panamera_turbo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_panamera_turbo_s),context.getString(R.string.porsche_panamera_turbo_s_s),context.getString(R.string.porsche_panamera_turbo_s_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_356),context.getString(R.string.porsche_356_s),context.getString(R.string.porsche_356_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.porsche_other),context.getString(R.string.porsche_other_s),context.getString(R.string.porsche_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarPontiacArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_6000),context.getString(R.string.pontiac_6000_s),context.getString(R.string.pontiac_6000_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_g5),context.getString(R.string.pontiac_g5_s),context.getString(R.string.pontiac_g5_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_g6),context.getString(R.string.pontiac_g6_s),context.getString(R.string.pontiac_g6_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_g8),context.getString(R.string.pontiac_g8_s),context.getString(R.string.pontiac_g8_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_gto),context.getString(R.string.pontiac_gto_s),context.getString(R.string.pontiac_gto_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_aztek),context.getString(R.string.pontiac_aztek_s),context.getString(R.string.pontiac_aztek_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_parisian),context.getString(R.string.pontiac_parisian_s),context.getString(R.string.pontiac_parisian_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_bonneville),context.getString(R.string.pontiac_bonneville_s),context.getString(R.string.pontiac_bonneville_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_trans_sport),context.getString(R.string.pontiac_trans_sport_s),context.getString(R.string.pontiac_trans_sport_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_tempest),context.getString(R.string.pontiac_tempest_s),context.getString(R.string.pontiac_tempest_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_grand_am),context.getString(R.string.pontiac_grand_am_s),context.getString(R.string.pontiac_grand_am_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_gto_grand_prix),context.getString(R.string.pontiac_gto_grand_prix_s),context.getString(R.string.pontiac_gto_grand_prix_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_g4),context.getString(R.string.pontiac_g4_s),context.getString(R.string.pontiac_g4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_solstice),context.getString(R.string.pontiac_solstice_s),context.getString(R.string.pontiac_solstice_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_sunbrid),context.getString(R.string.pontiac_sunbrid_s),context.getString(R.string.pontiac_sunbrid_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_vibe),context.getString(R.string.pontiac_vibe_s),context.getString(R.string.pontiac_vibe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_firebird),context.getString(R.string.pontiac_firebird_s),context.getString(R.string.pontiac_firebird_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_fiero),context.getString(R.string.pontiac_fiero_s),context.getString(R.string.pontiac_fiero_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_phoenix),context.getString(R.string.pontiac_phoenix_s),context.getString(R.string.pontiac_phoenix_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_le_mans),context.getString(R.string.pontiac_le_mans_s),context.getString(R.string.pontiac_le_mans_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_montana),context.getString(R.string.pontiac_montana_s),context.getString(R.string.pontiac_montana_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_roadster),context.getString(R.string.pontiac_roadster_s),context.getString(R.string.pontiac_roadster_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.pontiac_other),context.getString(R.string.pontiac_other_s),context.getString(R.string.pontiac_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarAston_martinArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_bd7),context.getString(R.string.aston_martin_bd7_s),context.getString(R.string.aston_martin_bd7_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_bd9),context.getString(R.string.aston_martin_bd9_s),context.getString(R.string.aston_martin_bd9_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_bdc),context.getString(R.string.aston_martin_bdc_s),context.getString(R.string.aston_martin_bdc_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_one_77),context.getString(R.string.aston_martin_one_77_s),context.getString(R.string.aston_martin_one_77_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_v12),context.getString(R.string.aston_martin_v12_s),context.getString(R.string.aston_martin_v12_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_v8),context.getString(R.string.aston_martin_v8_s),context.getString(R.string.aston_martin_v8_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_rapide),context.getString(R.string.aston_martin_rapide_s),context.getString(R.string.aston_martin_rapide_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_cygnet),context.getString(R.string.aston_martin_cygnet_s),context.getString(R.string.aston_martin_cygnet_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_vanquish),context.getString(R.string.aston_martin_vanquish_s),context.getString(R.string.aston_martin_vanquish_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_virage),context.getString(R.string.aston_martin_virage_s),context.getString(R.string.aston_martin_virage_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_lagonda),context.getString(R.string.aston_martin_lagonda_s),context.getString(R.string.aston_martin_lagonda_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_bd6),context.getString(R.string.aston_martin_bd6_s),context.getString(R.string.aston_martin_bd6_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_bds),context.getString(R.string.aston_martin_bds_s),context.getString(R.string.aston_martin_bds_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_v12_vantage),context.getString(R.string.aston_martin_v12_vantage_s),context.getString(R.string.aston_martin_v12_vantage_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_v8_vantage),context.getString(R.string.aston_martin_v8_vantage_s),context.getString(R.string.aston_martin_v8_vantage_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.aston_martin_other),context.getString(R.string.aston_martin_other_s),context.getString(R.string.aston_martin_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarAlfa_romeoArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_33),context.getString(R.string.alfa_romeo_33_s),context.getString(R.string.alfa_romeo_33_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_75),context.getString(R.string.alfa_romeo_75_s),context.getString(R.string.alfa_romeo_75_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_145),context.getString(R.string.alfa_romeo_145_s),context.getString(R.string.alfa_romeo_145_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_146),context.getString(R.string.alfa_romeo_146_s),context.getString(R.string.alfa_romeo_146_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_147),context.getString(R.string.alfa_romeo_147_s),context.getString(R.string.alfa_romeo_147_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_155),context.getString(R.string.alfa_romeo_155_s),context.getString(R.string.alfa_romeo_155_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_156),context.getString(R.string.alfa_romeo_156_s),context.getString(R.string.alfa_romeo_156_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_159),context.getString(R.string.alfa_romeo_159_s),context.getString(R.string.alfa_romeo_159_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_164),context.getString(R.string.alfa_romeo_164_s),context.getString(R.string.alfa_romeo_164_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_166),context.getString(R.string.alfa_romeo_166_s),context.getString(R.string.alfa_romeo_166_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_8c),context.getString(R.string.alfa_romeo_8c_s),context.getString(R.string.alfa_romeo_8c_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_90),context.getString(R.string.alfa_romeo_90_s),context.getString(R.string.alfa_romeo_90_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_gt),context.getString(R.string.alfa_romeo_gt_s),context.getString(R.string.alfa_romeo_gt_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_gtv),context.getString(R.string.alfa_romeo_gtv_s),context.getString(R.string.alfa_romeo_gtv_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_rz),context.getString(R.string.alfa_romeo_rz_s),context.getString(R.string.alfa_romeo_rz_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_sz),context.getString(R.string.alfa_romeo_sz_s),context.getString(R.string.alfa_romeo_sz_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_arna),context.getString(R.string.alfa_romeo_arna_s),context.getString(R.string.alfa_romeo_arna_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_brera),context.getString(R.string.alfa_romeo_brera_s),context.getString(R.string.alfa_romeo_brera_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_giulietta),context.getString(R.string.alfa_romeo_giulietta_s),context.getString(R.string.alfa_romeo_giulietta_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_giulia),context.getString(R.string.alfa_romeo_giulia_s),context.getString(R.string.alfa_romeo_giulia_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_spider),context.getString(R.string.alfa_romeo_spider_s),context.getString(R.string.alfa_romeo_spider_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_mito),context.getString(R.string.alfa_romeo_mito_s),context.getString(R.string.alfa_romeo_mito_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_4c),context.getString(R.string.alfa_romeo_4c_s),context.getString(R.string.alfa_romeo_4c_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.alfa_romeo_other),context.getString(R.string.alfa_romeo_other_s),context.getString(R.string.alfa_romeo_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarPeugeotArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_1xx),context.getString(R.string.peugeot_1xx_s),context.getString(R.string.peugeot_1xx_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_104),context.getString(R.string.peugeot_104_s),context.getString(R.string.peugeot_104_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_106),context.getString(R.string.peugeot_106_s),context.getString(R.string.peugeot_106_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_107),context.getString(R.string.peugeot_107_s),context.getString(R.string.peugeot_107_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_2xx),context.getString(R.string.peugeot_2xx_s),context.getString(R.string.peugeot_2xx_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_204),context.getString(R.string.peugeot_204_s),context.getString(R.string.peugeot_204_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_205),context.getString(R.string.peugeot_205_s),context.getString(R.string.peugeot_205_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_206),context.getString(R.string.peugeot_206_s),context.getString(R.string.peugeot_206_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_207),context.getString(R.string.peugeot_207_s),context.getString(R.string.peugeot_207_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_208),context.getString(R.string.peugeot_208_s),context.getString(R.string.peugeot_208_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_3xx),context.getString(R.string.peugeot_3xx_s),context.getString(R.string.peugeot_3xx_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_301),context.getString(R.string.peugeot_301_s),context.getString(R.string.peugeot_301_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_304),context.getString(R.string.peugeot_304_s),context.getString(R.string.peugeot_304_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_305),context.getString(R.string.peugeot_305_s),context.getString(R.string.peugeot_305_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_306),context.getString(R.string.peugeot_306_s),context.getString(R.string.peugeot_306_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_307),context.getString(R.string.peugeot_307_s),context.getString(R.string.peugeot_307_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_308),context.getString(R.string.peugeot_308_s),context.getString(R.string.peugeot_308_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_309),context.getString(R.string.peugeot_309_s),context.getString(R.string.peugeot_309_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_3008),context.getString(R.string.peugeot_3008_s),context.getString(R.string.peugeot_3008_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_4xx),context.getString(R.string.peugeot_4xx_s),context.getString(R.string.peugeot_4xx_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.Peugeot_405),context.getString(R.string.Peugeot_405_s),context.getString(R.string.Peugeot_405_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.Peugeot_406),context.getString(R.string.Peugeot_406_s),context.getString(R.string.Peugeot_406_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.Peugeot_407),context.getString(R.string.Peugeot_407_s),context.getString(R.string.Peugeot_407_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.Peugeot_408),context.getString(R.string.Peugeot_408_s),context.getString(R.string.Peugeot_408_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.Peugeot_4007),context.getString(R.string.Peugeot_4007_s),context.getString(R.string.Peugeot_4007_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.Peugeot_5xx),context.getString(R.string.Peugeot_5xx_s),context.getString(R.string.Peugeot_5xx_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.Peugeot_504),context.getString(R.string.Peugeot_504_s),context.getString(R.string.Peugeot_504_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.Peugeot_505),context.getString(R.string.Peugeot_505_s),context.getString(R.string.Peugeot_505_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.Peugeot_508),context.getString(R.string.Peugeot_508_s),context.getString(R.string.Peugeot_508_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_5008),context.getString(R.string.peugeot_5008_s),context.getString(R.string.peugeot_5008_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_6xx),context.getString(R.string.peugeot_6xx_s),context.getString(R.string.peugeot_6xx_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_604),context.getString(R.string.peugeot_604_s),context.getString(R.string.peugeot_604_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_605),context.getString(R.string.peugeot_605_s),context.getString(R.string.peugeot_605_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_607),context.getString(R.string.peugeot_607_s),context.getString(R.string.peugeot_607_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_8xx),context.getString(R.string.peugeot_8xx_s),context.getString(R.string.peugeot_8xx_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_806),context.getString(R.string.peugeot_806_s),context.getString(R.string.peugeot_806_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_807),context.getString(R.string.peugeot_807_s),context.getString(R.string.peugeot_807_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_rc),context.getString(R.string.peugeot_rc_s),context.getString(R.string.peugeot_rc_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_rcz),context.getString(R.string.peugeot_rcz_s),context.getString(R.string.peugeot_rcz_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_1007),context.getString(R.string.peugeot_1007_s),context.getString(R.string.peugeot_1007_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_2008),context.getString(R.string.peugeot_2008_s),context.getString(R.string.peugeot_2008_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_partner),context.getString(R.string.peugeot_partner_s),context.getString(R.string.peugeot_partner_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_boxer),context.getString(R.string.peugeot_boxer_s),context.getString(R.string.peugeot_boxer_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.peugeot_other),context.getString(R.string.peugeot_other_s),context.getString(R.string.peugeot_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarJaguarArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_e_pace),context.getString(R.string.jaguar_e_pace_s),context.getString(R.string.jaguar_e_pace_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_e_type),context.getString(R.string.jaguar_e_type_s),context.getString(R.string.jaguar_e_type_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_f_pace),context.getString(R.string.jaguar_f_pace_s),context.getString(R.string.jaguar_f_pace_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_f_type),context.getString(R.string.jaguar_f_type_s),context.getString(R.string.jaguar_f_type_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_s_type),context.getString(R.string.jaguar_s_type_s),context.getString(R.string.jaguar_s_type_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_x_type),context.getString(R.string.jaguar_x_type_s),context.getString(R.string.jaguar_x_type_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_xe),context.getString(R.string.jaguar_xe_s),context.getString(R.string.jaguar_xe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_xf),context.getString(R.string.jaguar_xf_s),context.getString(R.string.jaguar_xf_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_xfr),context.getString(R.string.jaguar_xfr_s),context.getString(R.string.jaguar_xfr_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_xj),context.getString(R.string.jaguar_xj_s),context.getString(R.string.jaguar_xj_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_xj220),context.getString(R.string.jaguar_xj220_s),context.getString(R.string.jaguar_xj220_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_xjr),context.getString(R.string.jaguar_xjr_s),context.getString(R.string.jaguar_xjr_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_xjs),context.getString(R.string.jaguar_xjs_s),context.getString(R.string.jaguar_xjs_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_xk),context.getString(R.string.jaguar_xk_s),context.getString(R.string.jaguar_xk_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_xkr_s),context.getString(R.string.jaguar_xkr_s_s),context.getString(R.string.jaguar_xkr_s_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_xkr),context.getString(R.string.jaguar_xkr_s),context.getString(R.string.jaguar_xkr_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_daimler_double_six),context.getString(R.string.jaguar_daimler_double_six_s),context.getString(R.string.jaguar_daimler_double_six_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_daimler),context.getString(R.string.jaguar_daimler_s),context.getString(R.string.jaguar_daimler_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_ss100),context.getString(R.string.jaguar_ss100_s),context.getString(R.string.jaguar_ss100_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_xj8),context.getString(R.string.jaguar_xj8_s),context.getString(R.string.jaguar_xj8_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.jaguar_other),context.getString(R.string.jaguar_other_s),context.getString(R.string.jaguar_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarGreat_wallArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_c30),context.getString(R.string.great_wall_c30_s),context.getString(R.string.great_wall_c30_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_m2),context.getString(R.string.great_wall_m2_s),context.getString(R.string.great_wall_m2_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_m4),context.getString(R.string.great_wall_m4_s),context.getString(R.string.great_wall_m4_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_peri),context.getString(R.string.great_wall_peri_s),context.getString(R.string.great_wall_peri_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_pegasus),context.getString(R.string.great_wall_pegasus_s),context.getString(R.string.great_wall_pegasus_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_deer),context.getString(R.string.great_wall_deer_s),context.getString(R.string.great_wall_deer_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_safe),context.getString(R.string.great_wall_safe_s),context.getString(R.string.great_wall_safe_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_sailor),context.getString(R.string.great_wall_sailor_s),context.getString(R.string.great_wall_sailor_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_socool),context.getString(R.string.great_wall_socool_s),context.getString(R.string.great_wall_socool_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_florid),context.getString(R.string.great_wall_florid_s),context.getString(R.string.great_wall_florid_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_voleex),context.getString(R.string.great_wall_voleex_s),context.getString(R.string.great_wall_voleex_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_cowry),context.getString(R.string.great_wall_cowry_s),context.getString(R.string.great_wall_cowry_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_coolbear),context.getString(R.string.great_wall_coolbear_s),context.getString(R.string.great_wall_coolbear_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_hover),context.getString(R.string.great_wall_hover_s),context.getString(R.string.great_wall_hover_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_wingle),context.getString(R.string.great_wall_wingle_s),context.getString(R.string.great_wall_wingle_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_haval),context.getString(R.string.great_wall_haval_s),context.getString(R.string.great_wall_haval_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.great_wall_other),context.getString(R.string.great_wall_other_s),context.getString(R.string.great_wall_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarGMCArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_acadia),context.getString(R.string.gmc_acadia_s),context.getString(R.string.gmc_acadia_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_envoy),context.getString(R.string.gmc_envoy_s),context.getString(R.string.gmc_envoy_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_typhoon),context.getString(R.string.gmc_typhoon_s),context.getString(R.string.gmc_typhoon_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_terrain),context.getString(R.string.gmc_terrain_s),context.getString(R.string.gmc_terrain_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_jimmy),context.getString(R.string.gmc_jimmy_s),context.getString(R.string.gmc_jimmy_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_savana),context.getString(R.string.gmc_savana_s),context.getString(R.string.gmc_savana_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_statesman),context.getString(R.string.gmc_statesman_s),context.getString(R.string.gmc_statesman_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_safari),context.getString(R.string.gmc_safari_s),context.getString(R.string.gmc_safari_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_suburban),context.getString(R.string.gmc_suburban_s),context.getString(R.string.gmc_suburban_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_sierra),context.getString(R.string.gmc_sierra_s),context.getString(R.string.gmc_sierra_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_vandura),context.getString(R.string.gmc_vandura_s),context.getString(R.string.gmc_vandura_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_caprice),context.getString(R.string.gmc_caprice_s),context.getString(R.string.gmc_caprice_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_calais),context.getString(R.string.gmc_calais_s),context.getString(R.string.gmc_calais_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_canyon),context.getString(R.string.gmc_canyon_s),context.getString(R.string.gmc_canyon_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_cruze),context.getString(R.string.gmc_cruze_s),context.getString(R.string.gmc_cruze_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_commodore),context.getString(R.string.gmc_commodore_s),context.getString(R.string.gmc_commodore_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_yokon),context.getString(R.string.gmc_yokon_s),context.getString(R.string.gmc_yokon_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.gmc_caballero),context.getString(R.string.gmc_caballero_s),context.getString(R.string.gmc_caballero_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarJeepArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.jeep_patriot),context.getString(R.string.jeep_patriot_s),context.getString(R.string.jeep_patriot_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jeep_grand_cherokee),context.getString(R.string.jeep_grand_cherokee_s),context.getString(R.string.jeep_grand_cherokee_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jeep_wrangler),context.getString(R.string.jeep_wrangler_s),context.getString(R.string.jeep_wrangler_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jeep_renegade),context.getString(R.string.jeep_renegade_s),context.getString(R.string.jeep_renegade_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jeep_cherokee),context.getString(R.string.jeep_cherokee_s),context.getString(R.string.jeep_cherokee_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jeep_commander),context.getString(R.string.jeep_commander_s),context.getString(R.string.jeep_commander_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jeep_comanche),context.getString(R.string.jeep_comanche_s),context.getString(R.string.jeep_comanche_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jeep_laredo),context.getString(R.string.jeep_laredo_s),context.getString(R.string.jeep_laredo_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jeep_liberty),context.getString(R.string.jeep_liberty_s),context.getString(R.string.jeep_liberty_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jeep_wagoneer),context.getString(R.string.jeep_wagoneer_s),context.getString(R.string.jeep_wagoneer_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.jeep_gldiator),context.getString(R.string.jeep_gldiator_s),context.getString(R.string.jeep_gldiator_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.jeep_other),context.getString(R.string.jeep_other_s),context.getString(R.string.jeep_other_ar)));
//
//        return carModelArrayList;
//    }
//
//    public static ArrayList<CarModel> fillCarDaihatsuArrayL
//            (ArrayList<CarModel> carModelArrayList, Context context) {
//
//        carModelArrayList = new ArrayList<>();
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_yrv),context.getString(R.string.daihatsu_yrv_s),context.getString(R.string.daihatsu_yrv_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_applause),context.getString(R.string.daihatsu_applause_s),context.getString(R.string.daihatsu_applause_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_atrai),context.getString(R.string.daihatsu_atrai_s),context.getString(R.string.daihatsu_atrai_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_alits),context.getString(R.string.daihatsu_alits_s),context.getString(R.string.daihatsu_alits_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_opti),context.getString(R.string.daihatsu_opti_s),context.getString(R.string.daihatsu_opti_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_esse),context.getString(R.string.daihatsu_esse_s),context.getString(R.string.daihatsu_esse_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_boon),context.getString(R.string.daihatsu_boon_s),context.getString(R.string.daihatsu_boon_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_perodua_viva),context.getString(R.string.daihatsu_perodua_viva_s),context.getString(R.string.daihatsu_perodua_viva_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_bazar),context.getString(R.string.daihatsu_bazar_s),context.getString(R.string.daihatsu_bazar_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_taft),context.getString(R.string.daihatsu_taft_s),context.getString(R.string.daihatsu_taft_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_tanto),context.getString(R.string.daihatsu_tanto_s),context.getString(R.string.daihatsu_tanto_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_trevis),context.getString(R.string.daihatsu_trevis_s),context.getString(R.string.daihatsu_trevis_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_charade),context.getString(R.string.daihatsu_charade_s),context.getString(R.string.daihatsu_charade_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_charmant),context.getString(R.string.daihatsu_charmant_s),context.getString(R.string.daihatsu_charmant_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_terios),context.getString(R.string.daihatsu_terios_s),context.getString(R.string.daihatsu_terios_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_grand_terios),context.getString(R.string.daihatsu_grand_terios_s),context.getString(R.string.daihatsu_grand_terios_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_delta),context.getString(R.string.daihatsu_delta_s),context.getString(R.string.daihatsu_delta_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_rocky),context.getString(R.string.daihatsu_rocky_s),context.getString(R.string.daihatsu_rocky_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_xenia),context.getString(R.string.daihatsu_xenia_s),context.getString(R.string.daihatsu_xenia_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_storia),context.getString(R.string.daihatsu_storia_s),context.getString(R.string.daihatsu_storia_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_sonica),context.getString(R.string.daihatsu_sonica_s),context.getString(R.string.daihatsu_sonica_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_ceria),context.getString(R.string.daihatsu_ceria_s),context.getString(R.string.daihatsu_ceria_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_sirion),context.getString(R.string.daihatsu_sirion_s),context.getString(R.string.daihatsu_sirion_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_feroza),context.getString(R.string.daihatsu_feroza_s),context.getString(R.string.daihatsu_feroza_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_kancil),context.getString(R.string.daihatsu_kancil_s),context.getString(R.string.daihatsu_kancil_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_copen),context.getString(R.string.daihatsu_copen_s),context.getString(R.string.daihatsu_copen_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_cuore),context.getString(R.string.daihatsu_cuore_s),context.getString(R.string.daihatsu_cuore_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_leeza),context.getString(R.string.daihatsu_leeza_s),context.getString(R.string.daihatsu_leeza_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_materia),context.getString(R.string.daihatsu_materia_s),context.getString(R.string.daihatsu_materia_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_move),context.getString(R.string.daihatsu_move_s),context.getString(R.string.daihatsu_move_ar)));
//
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_mira),context.getString(R.string.daihatsu_mira_s),context.getString(R.string.daihatsu_mira_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_fourtrak),context.getString(R.string.daihatsu_fourtrak_s),context.getString(R.string.daihatsu_fourtrak_ar)));
//        carModelArrayList.add(new CarModel(context.getString(R.string.daihatsu_other),context.getString(R.string.daihatsu_other_s),context.getString(R.string.daihatsu_other_ar)));
//
//        return carModelArrayList;
//    }

    public static ArrayList<CarModel> fillCarBMW1ArrayL
            (ArrayList<CarModel> carModelArrayList, Context context) {

        carModelArrayList = new ArrayList<>();


        return carModelArrayList;
    }
}
