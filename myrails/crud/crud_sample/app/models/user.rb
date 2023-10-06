class User < ApplicationRecord
    validates :name, presence: true, length: {maximum: 25}, uniqueness: {case_sensitive: false}
    validates :address, presence: true, length: {minimum: 1}
    validates :phone, presence: true, length: {in: 10..11}, numericality: {only_integer: true}
end
