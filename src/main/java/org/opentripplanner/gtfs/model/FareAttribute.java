/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package org.opentripplanner.gtfs.model;

import com.google.common.base.Optional;
import org.opentripplanner.gtfs.format.FeedFile;

import java.util.Currency;
import java.util.Map;

import static org.opentripplanner.gtfs.format.FeedFile.FARE_ATTRIBUTES;
import static org.opentripplanner.gtfs.validator.feed.FeedValidator.optionalInt;
import static org.opentripplanner.gtfs.validator.feed.FeedValidator.requiredCurrency;
import static org.opentripplanner.gtfs.validator.feed.FeedValidator.requiredDouble;
import static org.opentripplanner.gtfs.validator.feed.FeedValidator.requiredInt;
import static org.opentripplanner.gtfs.validator.feed.FeedValidator.requiredIntOptionalValue;
import static org.opentripplanner.gtfs.validator.feed.FeedValidator.requiredString;

public class FareAttribute {
    final static public FeedFile FEED_FILE = FARE_ATTRIBUTES;

    final public String fare_id;
    final public double price;
    final public Currency currency_type;
    final public int payment_method;
    final public Optional<Integer> transfers;
    final public Optional<Integer> transfer_duration;

    public FareAttribute(Map<String, String> row) {
        fare_id = requiredString(row, "fare_id", FEED_FILE);
        price = requiredDouble(row, "price", 0, Double.MAX_VALUE, FEED_FILE);
        currency_type = requiredCurrency(row, "currency_type", FEED_FILE);
        payment_method = requiredInt(row, "payment_method", 0, 1, FEED_FILE);
        transfers = requiredIntOptionalValue(row, "transfers", 0, 2, FEED_FILE);
        transfer_duration = optionalInt(row, "transfer_duration", 0, Integer.MAX_VALUE, FEED_FILE);
    }
}
