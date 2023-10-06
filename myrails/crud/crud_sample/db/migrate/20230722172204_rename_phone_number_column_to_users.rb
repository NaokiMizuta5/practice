class RenamePhoneNumberColumnToUsers < ActiveRecord::Migration[7.0]
  def change
    rename_column :users, :phone_number, :phone
  end
end
