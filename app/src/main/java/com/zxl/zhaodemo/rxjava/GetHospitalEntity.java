package com.zxl.zhaodemo.rxjava;

import java.util.List;

/**
 * 创建人：赵小磊
 * 创建时间：2016/12/9 0009 16:54
 * 描述：医院主页
 */
public class GetHospitalEntity {
    /**
     * Hospital : {"HospitalName":"爱上大声地","HospitalLevel":"","HPics":[],"bigPics":[],"CaseBaseCount":10,"ReservationBaseCount":10,"isFocus":false,"Address":"阿萨德撒的","Phone":"11111111111","Email":"112568559496","HospitalIntroduce":"                    "}
     * stairItemList : [{"itemId":1,"stairItemName":"1级列表名称","secondItemList":[{"secondItemId":2,"secondItemName":"二级项目类别","threeItemList":[{"threeItemId":4,"threeItemName":"qweqwe","PriceMin":0.005800252,"PriceMax":0.005800252}]}]},{"itemId":11,"stairItemName":"眼睛","secondItemList":[{"secondItemId":3,"secondItemName":"二级","threeItemList":[{"threeItemId":9,"threeItemName":"","PriceMin":0.6438279807,"PriceMax":0.6438279807},{"threeItemId":10,"threeItemName":"","PriceMin":0,"PriceMax":0},{"threeItemId":6,"threeItemName":"sss","PriceMin":10000,"PriceMax":11600.5041579107},{"threeItemId":7,"threeItemName":"","PriceMin":0.5800252078,"PriceMax":0.5800252078}]}]}]
     * doctors : [{"DoctorID":8,"DocName":"医生端测试账号","DocIcon":"/FileUpLaod/small60360ca2-3d84-4f97-9ba5-2c4923d5380e.jpg","bigPics":"/FileUpLaod/60360ca2-3d84-4f97-9ba5-2c4923d5380e.jpg"}]
     * HotProduct : [{"ProductID":2,"ProductIMg":"/FileUpLaod/smallea45f1c3-ff36-4a16-baba-69bc30141792.png","bigPics":"/FileUpLaod/ea45f1c3-ff36-4a16-baba-69bc30141792.png"}]
     */

    private HospitalBean Hospital;
    private List<StairItemListBean> stairItemList;
    private List<DoctorsBean> doctors;
    private List<HotProductBean> HotProduct;

    public HospitalBean getHospital() {
        return Hospital;
    }

    public void setHospital(HospitalBean Hospital) {
        this.Hospital = Hospital;
    }

    public List<StairItemListBean> getStairItemList() {
        return stairItemList;
    }

    public void setStairItemList(List<StairItemListBean> stairItemList) {
        this.stairItemList = stairItemList;
    }

    public List<DoctorsBean> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorsBean> doctors) {
        this.doctors = doctors;
    }

    public List<HotProductBean> getHotProduct() {
        return HotProduct;
    }

    public void setHotProduct(List<HotProductBean> HotProduct) {
        this.HotProduct = HotProduct;
    }

    public static class HospitalBean {
        /**
         * HospitalName : 爱上大声地
         * HospitalLevel :
         * HPics : []
         * bigPics : []
         * CaseBaseCount : 10
         * ReservationBaseCount : 10
         * isFocus : false
         * Address : 阿萨德撒的
         * Phone : 11111111111
         * Email : 112568559496
         * HospitalIntroduce :
         */

        private String HospitalName;
        private String HospitalLevel;
        private int CaseBaseCount;
        private int ReservationBaseCount;
        private boolean isFocus;
        private String Address;
        private String Phone;
        private String Email;
        private String HospitalIntroduce;
        private List<String> HPics;
        private List<String> bigPics;

        public String getHospitalName() {
            return HospitalName;
        }

        public void setHospitalName(String HospitalName) {
            this.HospitalName = HospitalName;
        }

        public String getHospitalLevel() {
            return HospitalLevel;
        }

        public void setHospitalLevel(String HospitalLevel) {
            this.HospitalLevel = HospitalLevel;
        }

        public int getCaseBaseCount() {
            return CaseBaseCount;
        }

        public void setCaseBaseCount(int CaseBaseCount) {
            this.CaseBaseCount = CaseBaseCount;
        }

        public int getReservationBaseCount() {
            return ReservationBaseCount;
        }

        public void setReservationBaseCount(int ReservationBaseCount) {
            this.ReservationBaseCount = ReservationBaseCount;
        }

        public boolean isIsFocus() {
            return isFocus;
        }

        public void setIsFocus(boolean isFocus) {
            this.isFocus = isFocus;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String Phone) {
            this.Phone = Phone;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getHospitalIntroduce() {
            return HospitalIntroduce;
        }

        public void setHospitalIntroduce(String HospitalIntroduce) {
            this.HospitalIntroduce = HospitalIntroduce;
        }

        public List<String> getHPics() {
            return HPics;
        }

        public void setHPics(List<String> HPics) {
            this.HPics = HPics;
        }

        public List<String> getBigPics() {
            return bigPics;
        }

        public void setBigPics(List<String> bigPics) {
            this.bigPics = bigPics;
        }
    }

    public static class StairItemListBean {
        /**
         * itemId : 1
         * stairItemName : 1级列表名称
         * secondItemList : [{"secondItemId":2,"secondItemName":"二级项目类别","threeItemList":[{"threeItemId":4,"threeItemName":"qweqwe","PriceMin":0.005800252,"PriceMax":0.005800252}]}]
         */

        private int itemId;
        private String stairItemName;
        private List<SecondItemListBean> secondItemList;

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public String getStairItemName() {
            return stairItemName;
        }

        public void setStairItemName(String stairItemName) {
            this.stairItemName = stairItemName;
        }

        public List<SecondItemListBean> getSecondItemList() {
            return secondItemList;
        }

        public void setSecondItemList(List<SecondItemListBean> secondItemList) {
            this.secondItemList = secondItemList;
        }

        public static class SecondItemListBean {
            /**
             * secondItemId : 2
             * secondItemName : 二级项目类别
             * threeItemList : [{"threeItemId":4,"threeItemName":"qweqwe","PriceMin":0.005800252,"PriceMax":0.005800252}]
             */

            private int secondItemId;
            private String secondItemName;
            private List<ThreeItemListBean> threeItemList;

            public int getSecondItemId() {
                return secondItemId;
            }

            public void setSecondItemId(int secondItemId) {
                this.secondItemId = secondItemId;
            }

            public String getSecondItemName() {
                return secondItemName;
            }

            public void setSecondItemName(String secondItemName) {
                this.secondItemName = secondItemName;
            }

            public List<ThreeItemListBean> getThreeItemList() {
                return threeItemList;
            }

            public void setThreeItemList(List<ThreeItemListBean> threeItemList) {
                this.threeItemList = threeItemList;
            }

            public static class ThreeItemListBean {
                /**
                 * threeItemId : 4
                 * threeItemName : qweqwe
                 * PriceMin : 0.005800252
                 * PriceMax : 0.005800252
                 */

                private int threeItemId;
                private String threeItemName;
                private double PriceMin;
                private double PriceMax;

                public int getThreeItemId() {
                    return threeItemId;
                }

                public void setThreeItemId(int threeItemId) {
                    this.threeItemId = threeItemId;
                }

                public String getThreeItemName() {
                    return threeItemName;
                }

                public void setThreeItemName(String threeItemName) {
                    this.threeItemName = threeItemName;
                }

                public double getPriceMin() {
                    return PriceMin;
                }

                public void setPriceMin(double PriceMin) {
                    this.PriceMin = PriceMin;
                }

                public double getPriceMax() {
                    return PriceMax;
                }

                public void setPriceMax(double PriceMax) {
                    this.PriceMax = PriceMax;
                }
            }
        }
    }

    public static class DoctorsBean {
        /**
         * DoctorID : 8
         * DocName : 医生端测试账号
         * DocIcon : /FileUpLaod/small60360ca2-3d84-4f97-9ba5-2c4923d5380e.jpg
         * bigPics : /FileUpLaod/60360ca2-3d84-4f97-9ba5-2c4923d5380e.jpg
         */

        private int DoctorID;
        private String DocName;
        private String DocIcon;
        private String bigPics;

        public int getDoctorID() {
            return DoctorID;
        }

        public void setDoctorID(int DoctorID) {
            this.DoctorID = DoctorID;
        }

        public String getDocName() {
            return DocName;
        }

        public void setDocName(String DocName) {
            this.DocName = DocName;
        }

        public String getDocIcon() {
            return DocIcon;
        }

        public void setDocIcon(String DocIcon) {
            this.DocIcon = DocIcon;
        }

        public String getBigPics() {
            return bigPics;
        }

        public void setBigPics(String bigPics) {
            this.bigPics = bigPics;
        }
    }

    public static class HotProductBean {
        /**
         * ProductID : 2
         * ProductIMg : /FileUpLaod/smallea45f1c3-ff36-4a16-baba-69bc30141792.png
         * bigPics : /FileUpLaod/ea45f1c3-ff36-4a16-baba-69bc30141792.png
         */

        private int ProductID;
        private String ProductIMg;
        private String bigPics;

        public int getProductID() {
            return ProductID;
        }

        public void setProductID(int ProductID) {
            this.ProductID = ProductID;
        }

        public String getProductIMg() {
            return ProductIMg;
        }

        public void setProductIMg(String ProductIMg) {
            this.ProductIMg = ProductIMg;
        }

        public String getBigPics() {
            return bigPics;
        }

        public void setBigPics(String bigPics) {
            this.bigPics = bigPics;
        }
    }


//    /**
//     * Hospital : {"HospitalName":"医院","HPics":["/FileUpLaod/small87800cd9-52fd-46e9-94b5-d225d02aed01.jpg","/FileUpLaod/smallb5daf28a-a4c2-4bc9-9797-63e559f1a1a3.jpg","/FileUpLaod/smalla97df12c-e82b-412c-b861-3e2974f99ac7.jpg"],"bigPics":["/FileUpLaod/87800cd9-52fd-46e9-94b5-d225d02aed01.jpg","/FileUpLaod/b5daf28a-a4c2-4bc9-9797-63e559f1a1a3.jpg","/FileUpLaod/a97df12c-e82b-412c-b861-3e2974f99ac7.jpg"],"CaseBaseCount":238,"ReservationBaseCount":0,"Address":"石家庄富强大街","Phone":"400-5553-444","Email":"meirongyiyuan@163.com","HospitalIntroduce":"优势"}
//     * stairItemList : [{"itemId":14,"stairItemName":"一级列表名称","secondItemList":[{"secondItemId":18,"secondItemName":"二级列表名称","threeItemList":[{"threeItemId":1,"threeItemName":"开内双眼皮","PriceMin":100,"PriceMax":100},{"threeItemId":2,"threeItemName":"开外","PriceMin":600,"PriceMax":1200}]}]}]
//     * doctors : []
//     * HotProduct : []
//     */
//
//    private HospitalBean Hospital;
//    private List<StairItemListBean> stairItemList;
//    private List<DoctorsBean> doctors;
//    private List<HotProductBean> HotProduct;
//
//    public HospitalBean getHospital() {
//        return Hospital;
//    }
//
//    public void setHospital(HospitalBean Hospital) {
//        this.Hospital = Hospital;
//    }
//
//    public List<StairItemListBean> getStairItemList() {
//        return stairItemList;
//    }
//
//    public void setStairItemList(List<StairItemListBean> stairItemList) {
//        this.stairItemList = stairItemList;
//    }
//
//    public List<DoctorsBean> getDoctors() {
//        return doctors;
//    }
//
//    public void setDoctors(List<DoctorsBean> doctors) {
//        this.doctors = doctors;
//    }
//
//    public List<HotProductBean> getHotProduct() {
//        return HotProduct;
//    }
//
//    public void setHotProduct(List<HotProductBean> HotProduct) {
//        this.HotProduct = HotProduct;
//    }
//
//    public static class DoctorsBean {
//        public int getDoctorID() {
//            return DoctorID;
//        }
//
//        public void setDoctorID(int doctorID) {
//            DoctorID = doctorID;
//        }
//
//        int DoctorID;
//        private String DocName;
//        private String DocIcon;
//        private String bigPics;
//        public String getDocName() {
//            return DocName;
//        }
//
//        public void setDocName(String docName) {
//            DocName = docName;
//        }
//
//        public String getDocIcon() {
//            return DocIcon;
//        }
//
//        public void setDocIcon(String docIcon) {
//            DocIcon = docIcon;
//        }
//
//        public String getBigPics() {
//            return bigPics;
//        }
//
//        public void setBigPics(String bigPics) {
//            this.bigPics = bigPics;
//        }
//
//
//    }
//
//
//    public static class HotProductBean {
//        int ProductID;
//        private String ProductIMg;
//        private String bigPics;
//        public int getProductID() {
//            return ProductID;
//        }
//
//        public void setProductID(int productID) {
//            ProductID = productID;
//        }
//
//        public String getProductIMg() {
//            return ProductIMg;
//        }
//
//        public void setProductIMg(String productIMg) {
//            ProductIMg = productIMg;
//        }
//
//        public String getBigPics() {
//            return bigPics;
//        }
//
//        public void setBigPics(String bigPics) {
//            this.bigPics = bigPics;
//        }
//
//
//
//    }
//
//    public static class HospitalBean {
//        /**
//         * HospitalName : 医院
//         * HPics : ["/FileUpLaod/small87800cd9-52fd-46e9-94b5-d225d02aed01.jpg","/FileUpLaod/smallb5daf28a-a4c2-4bc9-9797-63e559f1a1a3.jpg","/FileUpLaod/smalla97df12c-e82b-412c-b861-3e2974f99ac7.jpg"]
//         * bigPics : ["/FileUpLaod/87800cd9-52fd-46e9-94b5-d225d02aed01.jpg","/FileUpLaod/b5daf28a-a4c2-4bc9-9797-63e559f1a1a3.jpg","/FileUpLaod/a97df12c-e82b-412c-b861-3e2974f99ac7.jpg"]
//         * CaseBaseCount : 238
//         * ReservationBaseCount : 0
//         * Address : 石家庄富强大街
//         * Phone : 400-5553-444
//         * Email : meirongyiyuan@163.com
//         * HospitalIntroduce : 优势
//         */
//
//        private String HospitalLevel;
//        private boolean isFocus;
//
//
//
//        private String HospitalName;
//        private int CaseBaseCount;
//        private int ReservationBaseCount;
//        private String Address;
//        private String Phone;
//        private String Email;
//        private String HospitalIntroduce;
//        private List<String> HPics;
//        private List<String> bigPics;
//        public String getHospitalLevel() {
//            return HospitalLevel;
//        }
//
//        public void setHospitalLevel(String hospitalLevel) {
//            HospitalLevel = hospitalLevel;
//        }
//
//        public boolean isFocus() {
//            return isFocus;
//        }
//
//        public void setFocus(boolean focus) {
//            isFocus = focus;
//        }
//        public String getHospitalName() {
//            return HospitalName;
//        }
//
//        public void setHospitalName(String HospitalName) {
//            this.HospitalName = HospitalName;
//        }
//
//        public int getCaseBaseCount() {
//            return CaseBaseCount;
//        }
//
//        public void setCaseBaseCount(int CaseBaseCount) {
//            this.CaseBaseCount = CaseBaseCount;
//        }
//
//        public int getReservationBaseCount() {
//            return ReservationBaseCount;
//        }
//
//        public void setReservationBaseCount(int ReservationBaseCount) {
//            this.ReservationBaseCount = ReservationBaseCount;
//        }
//
//        public String getAddress() {
//            return Address;
//        }
//
//        public void setAddress(String Address) {
//            this.Address = Address;
//        }
//
//        public String getPhone() {
//            return Phone;
//        }
//
//        public void setPhone(String Phone) {
//            this.Phone = Phone;
//        }
//
//        public String getEmail() {
//            return Email;
//        }
//
//        public void setEmail(String Email) {
//            this.Email = Email;
//        }
//
//        public String getHospitalIntroduce() {
//            return HospitalIntroduce;
//        }
//
//        public void setHospitalIntroduce(String HospitalIntroduce) {
//            this.HospitalIntroduce = HospitalIntroduce;
//        }
//
//        public List<String> getHPics() {
//            return HPics;
//        }
//
//        public void setHPics(List<String> HPics) {
//            this.HPics = HPics;
//        }
//
//        public List<String> getBigPics() {
//            return bigPics;
//        }
//
//        public void setBigPics(List<String> bigPics) {
//            this.bigPics = bigPics;
//        }
//    }
//
//    public static class StairItemListBean {
//        /**
//         * itemId : 14
//         * stairItemName : 一级列表名称
//         * secondItemList : [{"secondItemId":18,"secondItemName":"二级列表名称","threeItemList":[{"threeItemId":1,"threeItemName":"开内双眼皮","PriceMin":100,"PriceMax":100},{"threeItemId":2,"threeItemName":"开外","PriceMin":600,"PriceMax":1200}]}]
//         */
//
//        private int itemId;
//        private String stairItemName;
//        private List<SecondItemListBean> secondItemList;
//
//        public int getItemId() {
//            return itemId;
//        }
//
//        public void setItemId(int itemId) {
//            this.itemId = itemId;
//        }
//
//        public String getStairItemName() {
//            return stairItemName;
//        }
//
//        public void setStairItemName(String stairItemName) {
//            this.stairItemName = stairItemName;
//        }
//
//        public List<SecondItemListBean> getSecondItemList() {
//            return secondItemList;
//        }
//
//        public void setSecondItemList(List<SecondItemListBean> secondItemList) {
//            this.secondItemList = secondItemList;
//        }
//
//        public static class SecondItemListBean {
//            /**
//             * secondItemId : 18
//             * secondItemName : 二级列表名称
//             * threeItemList : [{"threeItemId":1,"threeItemName":"开内双眼皮","PriceMin":100,"PriceMax":100},{"threeItemId":2,"threeItemName":"开外","PriceMin":600,"PriceMax":1200}]
//             */
//
//            private int secondItemId;
//            private String secondItemName;
//            private List<ThreeItemListBean> threeItemList;
//
//            public int getSecondItemId() {
//                return secondItemId;
//            }
//
//            public void setSecondItemId(int secondItemId) {
//                this.secondItemId = secondItemId;
//            }
//
//            public String getSecondItemName() {
//                return secondItemName;
//            }
//
//            public void setSecondItemName(String secondItemName) {
//                this.secondItemName = secondItemName;
//            }
//
//            public List<ThreeItemListBean> getThreeItemList() {
//                return threeItemList;
//            }
//
//            public void setThreeItemList(List<ThreeItemListBean> threeItemList) {
//                this.threeItemList = threeItemList;
//            }
//
//            public static class ThreeItemListBean {
//                /**
//                 * threeItemId : 1
//                 * threeItemName : 开内双眼皮
//                 * PriceMin : 100
//                 * PriceMax : 100
//                 */
//
//                private int threeItemId;
//                private String threeItemName;
//                private int PriceMin;
//                private int PriceMax;
//
//                public int getThreeItemId() {
//                    return threeItemId;
//                }
//
//                public void setThreeItemId(int threeItemId) {
//                    this.threeItemId = threeItemId;
//                }
//
//                public String getThreeItemName() {
//                    return threeItemName;
//                }
//
//                public void setThreeItemName(String threeItemName) {
//                    this.threeItemName = threeItemName;
//                }
//
//                public int getPriceMin() {
//                    return PriceMin;
//                }
//
//                public void setPriceMin(int PriceMin) {
//                    this.PriceMin = PriceMin;
//                }
//
//                public int getPriceMax() {
//                    return PriceMax;
//                }
//
//                public void setPriceMax(int PriceMax) {
//                    this.PriceMax = PriceMax;
//                }
//            }
//        }
//    }

}
