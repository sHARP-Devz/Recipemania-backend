@Named("bondCreate")
@ShadowedDataObject(value = "BondCreate", product = ProductTypes.BND, event = EventTypes.CREATE)
public class BondCreate extends WorkflowEnabled {
    @Id
    private Long id;
    @RefAnnotation(description = "Reference")
    @AdviceLabelAnnotation(value = "Reference")
    private String dealReference;
    private  Long product;
    @DateAnnotation(description = "Trade Date")
    private LocalDate tradeDate;
    private String status;
    @ShadowedDataField(code = "TRADINGBOOK", narrative = "Trading Book", value = FieldTypes.TRADINGBOOK)
    private Long tradingBook;
    private String dealer;
    @ShadowedDataField(code = "PORTFOLIO", narrative = "Portfolio", value = FieldTypes.PORTFOLIO)
    private Long portfolio;
    private Long businessUnit;
    private Long legalEntity;
    @AdviceLabelAnnotation(value = "CounterParty Reference")
    private String  counterPartyRef;
    private static final long serialVersionUID = 1999999999L;
    private BigDecimal nextCouponAmt;
    private String commonRef, dealType,direction, serviceScope;
    @AmountAnnotation(description = "Dirty price")
    private BigDecimal dirtyPrice;
    @AmountAnnotation(description = "Consideration")
    private BigDecimal consideration;
    private Long issueId;
    private String issue;
    private String boughtPrem;
    private String investmentType;
    private int quantity;
    @AmountAnnotation(description = "Discount / Premium price")
    private BigDecimal discPremium;
    @AmountAnnotation(description = "Nominal Amount")
    private BigDecimal norminalAmt;
    @CurrencyAnnotation(description = "Nominal Amount Currency")
    private String norminalAmtCode;
    private String inBoughtOption;
    @AmountAnnotation(description = "Clean price")
    private BigDecimal cleanPrice;
    @AmountAnnotation(description = "Interest Bought/Sold")
    private BigDecimal intBoughtSold;
    @DateAnnotation(description = "Start Date")
    private LocalDate startDate;
    @DateAnnotation(description = "Next Coupon Date")
    private LocalDate
            nextCouponDate;
    @DateAnnotation(description = "Maturity Date")
    private LocalDate
            maturityDate;
    @DateAnnotation(description = "Last Coupon Date")
    private LocalDate
            lastCouponDate ;


    @AmountAnnotation(description = "Day Current Accrual")
    private int dayCurrentAccrual;
    @AmountAnnotation(description = "Tenor")
    private String  tenorVal;
    @AmountAnnotation(description = "Tenor in days ")
    private int tenor;
    @AmountAnnotation(description = "Coupon rate")
    private BigDecimal couponRate;
    @AmountAnnotation(description = "Interest Accrued")
    private BigDecimal interestAccrued;
    @AmountAnnotation(description = "Interest Accrued Adjustment")
    private BigDecimal interestAccruedAdj;
    @AmountAnnotation(description = "Day Count Basis")
    private String dayCountBasis;
    @AmountAnnotation(description = "Daily interest Amount")
    private BigDecimal dailyIntAmt;
    @AmountAnnotation(description = "Discount/Premium Amortized")
    private BigDecimal  discPremArmotized;
    @AmountAnnotation(description = "Discount/Premium Amortized Adjustment")
    private BigDecimal   discPremArmotizedAdj;
    @AdviceLabelAnnotation(value = "Dealing Method")
    private String dealingMethod;
    @AdviceLabelAnnotation(value = "Interest Bought Sold")
    private String intBoughtSoldOpt;
    @AdviceLabelAnnotation(value = "Confirmation Instructioin")
    private String confirmInstruction;
    @AdviceLabelAnnotation(value = "Broker Reference")
    private String brokerRef;
    @CurrencyAnnotation(description = "Base Currency")
    private String baseFgnEquiRateCurr;
    @AmountAnnotation(description = "Base Currency Amount")
    private BigDecimal baseFgnEquiRateFig;
    @AmountAnnotation(description = "Base Currency Rate")
    private String baseFgnEquiRateExtra;
    @CurrencyAnnotation(description = "Local Currency")
    private String localEquiRateCurr;
    @AmountAnnotation(description = "Local Currency Amount")
    private BigDecimal localEquiRateFig;
    @AmountAnnotation(description = "Local Currency Rate")
    private String localEquiRateExtra;
    private Long broker;
    @AdviceLabelAnnotation(value = "Deal Note")
    private String  dealNote;
    @AdviceLabelAnnotation(value = "Confirmation Required")
    private String confirmReq;
    @AdviceLabelAnnotation(value = "Confirmation Instruction")
    private String confirmInstr;
    @AdviceLabelAnnotation(value = "Process Comment")
    private String processComment;
    @AdviceLabelAnnotation(value = "Issuer")
    private String issuerS;
    @AmountAnnotation(description = "Brokers commission")
    private BigDecimal brokerCommision;
    @AmountAnnotation(description = "Currency Yield")
    private BigDecimal currentYield;
    @CurrencyAnnotation(description = "Broker Commission Currency")
    private String brokerCommisionVal;
    @AccountAnnotation(description = "Charge Account")
    private String chargeAccount;
    @AccountAnnotation(description = "Settlement Account")
    private String settlementAccount;
    @AmountAnnotation(description = "Effective Interest Rate")
    private BigDecimal eir;
    @AmountAnnotation(description = "Daily Amortization Amount")
    private BigDecimal dailyAmort;
    @AdviceLabelAnnotation(value = "Coupon Duration")
    private Long couponDuration;