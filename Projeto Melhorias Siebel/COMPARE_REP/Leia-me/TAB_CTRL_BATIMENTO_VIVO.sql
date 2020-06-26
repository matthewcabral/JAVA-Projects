SET DEFINE OFF;
Insert into TAB_CTRL_BATIMENTO_REP
   (ID, FILA, CONFIGURATION_NAME, TYPE, GROUP_OBJECT, 
    ORDER_COL, DESCRIPTION, TABLE_NAME, JOIN0, TAB_P0, 
    INACTIVE_FLG,OTHER_KEY_FIELD)
 Values
   (358, 31, 'NV', 'NoRepository', 'AdjustmentGroup', 
    1, 'Product-BasedAdjustment', 'S_ADJ_GROUP', null, null, 
    'N','ADJ_GROUP_NAME');
Insert into TAB_CTRL_BATIMENTO_REP
   (ID, FILA, CONFIGURATION_NAME, TYPE, GROUP_OBJECT, 
    ORDER_COL, DESCRIPTION, TABLE_NAME, JOIN0, TAB_P0, 
    INACTIVE_FLG,OTHER_KEY_FIELD,ADDITIONAL_SEARCH)
 Values
   (359, 31, 'NV', 'NoRepository', 'AdjustmentGroup', 
    2, 'Product-BasedAdjustment', 'S_STDPROD_PMTRX', 'S_ADJ_GROUP', 'ADJ_GROUP_ID', 'N',
    'T.PROD_ID || '' - '' || T.REGION_NAME || '' - '' || T.X_MODALITY || '' - '' || T.X_PLAN_ID || '' - '' || T.X_STATE || '' - '' || (select NAME from SIEBEL.CX_PORTFL_GROUP@ TAB WHERE T.X_PORTFOLIO_ID = TAB.ROW_ID) || '' - '' || T.X_PROMOTION_ID || '' - '' || T.MIN_QTY || '' - '' || T.MAX_QTY || '' - '' || T.X_POSITION_TYPE || '' - '' || T.X_EXHIBITION_MODE || '' - '' || T.X_DEVICE_SKU || '' - '' || T.X_SALE_CHANNEL || '' - '' || T.X_USE_TYPE || '' - '' || T.PRI_TYPE_CD',
    '(T.EFF_END_DT IS NULL OR T.EFF_END_DT > SYSDATE)');
Insert into TAB_CTRL_BATIMENTO_REP
   (ID, FILA, CONFIGURATION_NAME, TYPE, GROUP_OBJECT, 
    ORDER_COL, DESCRIPTION, TABLE_NAME, JOIN0, TAB_P0, 
    INACTIVE_FLG,OTHER_KEY_FIELD)
 Values
   (360, 31, 'NV', 'NoRepository', 'Product', 
    1, 'Product', 'S_PROD_INT', null, null, 
   'N','T.PROMO_TYPE_CD <> ''Cupons''');
Insert into TAB_CTRL_BATIMENTO_REP
   (ID, FILA, CONFIGURATION_NAME, TYPE, GROUP_OBJECT, 
    ORDER_COL, DESCRIPTION, TABLE_NAME, JOIN0, TAB_P0, 
    INACTIVE_FLG,OTHER_KEY_FIELD)
 Values
   (361, 31, 'NV', 'NoRepository', 'AdjustmentGroup', 
    2, 'ProductEligibility', 'S_PRODELIG_MTRX', 'ADJ_GROUP_ID', 'S_ADJ_GROUP', 
    'N','MTRX_RULE_NUM');
Insert into TAB_CTRL_BATIMENTO_REP
   (ID, FILA, CONFIGURATION_NAME, TYPE, GROUP_OBJECT, 
    ORDER_COL, DESCRIPTION, TABLE_NAME, JOIN0, TAB_P0, 
    INACTIVE_FLG,OTHER_KEY_FIELD)
 Values
   (362, 32, 'NV', 'NoRepository', 'UIObject', 
    1, 'UIObject', 'S_UI_OBJECT', null, null, 
    'N', 'NAME, USAGE_TYPE_CD');
Insert into TAB_CTRL_BATIMENTO_REP
   (ID, FILA, CONFIGURATION_NAME, TYPE, GROUP_OBJECT, 
    ORDER_COL, DESCRIPTION, TABLE_NAME, JOIN0, TAB_P0, 
    INACTIVE_FLG,OTHER_KEY_FIELD)
 Values
   (363, 32, 'NV', 'NoRepository', 'UIFiles', 
    1, 'UIFiles', 'S_UI_FILE', null, null, 
    'N',null);
COMMIT;