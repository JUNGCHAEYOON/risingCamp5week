package com.example.risingcamp5week.retrofit


import com.squareup.moshi.Json

data class SRResponse(
    @field:Json(name = "SafetyRestrntInfo")
    val safetyRestrntInfo: List<SafetyRestrntInfo?>?
)

data class Head(
    @field:Json(name = "api_version")
    val apiVersion: String?,
    @field:Json(name = "list_total_count")
    val listTotalCount: Int?,
    @field:Json(name = "RESULT")
    val rESULT: RESULT?
)

data class RESULT(
    @field:Json(name = "CODE")
    val cODE: String?,
    @field:Json(name = "MESSAGE")
    val mESSAGE: String?
)

data class Row(
    // 식당명
    @field:Json(name = "BIZPLC_NM")
    val bIZPLCNM: String?,

    @field:Json(name = "CANCL_DE")
    val cANCLDE: Any?,
    @field:Json(name = "DETAIL_ADDR")
    val dETAILADDR: String?,

    // 업종명
    @field:Json(name = "INDUTYPE_DETAIL_NM")
    val iNDUTYPEDETAILNM: String?,

    @field:Json(name = "INDUTYPE_NM")
    val iNDUTYPENM: String?,
    @field:Json(name = "REFINE_LOTNO_ADDR")
    val rEFINELOTNOADDR: String?,
    @field:Json(name = "REFINE_ROADNM_ADDR")
    val rEFINEROADNMADDR: String?,

    // LAT
    @field:Json(name = "REFINE_WGS84_LAT")
    val rEFINEWGS84LAT: String?,

    // LONG
    @field:Json(name = "REFINE_WGS84_LOGT")
    val rEFINEWGS84LOGT: String?,

    @field:Json(name = "REFINE_ZIPNO")
    val rEFINEZIPNO: String?,
    @field:Json(name = "RM_MATR")
    val rMMATR: Any?,
    @field:Json(name = "SAFETY_RESTRNT_NO")
    val sAFETYRESTRNTNO: Int?,
    @field:Json(name = "SIDO_NM")
    val sIDONM: String?,
    @field:Json(name = "SIGNGU_NM")
    val sIGNGUNM: String?,
    @field:Json(name = "SLCTN_YN_DIV")
    val sLCTNYNDIV: String?,
    @field:Json(name = "TELNO")
    val tELNO: String?,
    @field:Json(name = "UPD_DAY")
    val uPDDAY: Any?
)

data class SafetyRestrntInfo(
    @field:Json(name = "head")
    val head: List<Head?>?,
    @field:Json(name = "row")
    val row: List<Row?>?
)