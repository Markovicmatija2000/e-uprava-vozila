package com.project.mup_vehicles.dtos;


    public class ViolationDTO
    {
        private Long id; private
        String description;
        private Double fineAmount;
        private Boolean paid;
        private String driverJmbg;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Double getFineAmount() {
            return fineAmount;
        }

        public void setFineAmount(Double fineAmount) {
            this.fineAmount = fineAmount;
        }

        public Boolean getPaid() {
            return paid;
        }

        public void setPaid(Boolean paid) {
            this.paid = paid;
        }

        public String getDriverJmbg() {
            return driverJmbg;
        }

        public void setDriverJmbg(String driverJmbg) {
            this.driverJmbg = driverJmbg;
        }
    }

